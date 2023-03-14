package com.seongyun.board.service;

import com.seongyun.board.dto.ResponseDto;
import com.seongyun.board.dto.SignInDto;
import com.seongyun.board.dto.SignInResponseDto;
import com.seongyun.board.dto.SignUpDto;
import com.seongyun.board.entity.TBuserEntity;
import com.seongyun.board.repository.TBuserRepository;
import com.seongyun.board.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired TBuserRepository TBuserRepository;
    @Autowired TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPwd = dto.getUserPwd();
        String userPwdChk = dto.getUserPwdChk();

        //email (PK) 중복체크
        try {
            if(TBuserRepository.existsById(userEmail))
                return  ResponseDto.setFail("existed Email!");
        }
        catch (Exception ex)
        {
            return ResponseDto.setFail("DataBase Error! 1");
        }

        //비밀번호 서로 다르면 failed response 반환
        if(!userPwd.equals(userPwdChk))
            return ResponseDto.setFail("Password does not matched!");

        //userentity 생성
        TBuserEntity TBuserEntity = new TBuserEntity(dto);

        //비밀번호 암호화
        String encodedUserPwd = passwordEncoder.encode(userPwd);
        TBuserEntity.setTbUserPwd(encodedUserPwd);

        //TBuserRepository 이용해 DB에 entity 저장
        try{
            TBuserRepository.save(TBuserEntity);
        }
        catch (Exception ex)
        {
            return ResponseDto.setFail("DataBase Error! 2");
        }

        return ResponseDto.setSuccess("SignUP Success!", null);
    }

    public ResponseDto<SignInResponseDto> SignIn(SignInDto dto) {
        String userEmail = dto.getUserEmail();
        String userPwd = dto.getUserPwd();
        TBuserEntity userEntity = null;

//        try {
//            //dto안에 있는 ID값 먼저 불러옴
////            boolean existed = TBuserRepository.existsByTbUserEmailAndTbUserPwd(userEmail, userPwd);
////            if(!existed)
////                return ResponseDto.setFail("Sign In Information does not match : 회원정보 불일치");
//        }
//        catch (Exception ex)
//        {
//            return ResponseDto.setFail("Database Error! 3");
//        }

        try {
            //userEntity 값을 ID = 이메일 값으로만 가져옴
            //userEntity = TBuserRepository.findById(userEmail).get();

            //이메일 체크하여 잘못되었으면 failed
            userEntity = TBuserRepository.findByTbUserEmail(userEmail);

            if(userEntity == null)
                return ResponseDto.setFail("Sign In Failed!");

            //인코더 비밀번호 값과 엔티티 비밀번호 값이 매칭 안되면 failed
            if(!passwordEncoder.matches(userPwd, userEntity.getTbUserPwd()))
                return ResponseDto.setFail("Sign In Failed!");
        }
        catch (Exception ex)
        {
            return ResponseDto.setFail("Database Error! 4");
        }
        //그리고 비밀번호 빈값으로 처리
        userEntity.setTbUserPwd("");

        String token = tokenProvider.create(userEmail);
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);

        return ResponseDto.setSuccess("Sign In success", signInResponseDto);
    }
}
