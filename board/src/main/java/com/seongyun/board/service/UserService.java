package com.seongyun.board.service;

import com.seongyun.board.dto.PatchUserRequestDto;
import com.seongyun.board.dto.PatchUserResponseDto;
import com.seongyun.board.dto.ResponseDto;
import com.seongyun.board.entity.TBuserEntity;
import com.seongyun.board.repository.TBuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired TBuserRepository tBuserRepository;
    public ResponseDto<PatchUserResponseDto> patchUser(PatchUserRequestDto dto, String userEmail)
    {
        TBuserEntity userEntity = null;
        String userNickname = dto.getTbUserNickname();
        String userProfile = dto.getTbUserProfile();
        try {
            userEntity = tBuserRepository.findByTbUserEmail(userEmail);
            if(userEntity == null)
                return ResponseDto.setFail("Does not exist User");

            userEntity.setTbUserNickname(userNickname);
            userEntity.setTbUserProfile(userProfile);

            tBuserRepository.save(userEntity);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseDto.setFail("DataBase Error");
        }
        userEntity.setTbUserPwd("");

        PatchUserResponseDto patchUserResponseDto = new PatchUserResponseDto(userEntity);

        return ResponseDto.setSuccess("Success", patchUserResponseDto);
    }
}
