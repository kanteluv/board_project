import { useState } from "react";
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import { Button, Typography } from "@mui/material";
import { signUpApi } from "../../../apis";

interface Props {
    setAuthView: (AuthView: boolean) => void, 
}

export default function SignUp(props: Props) {
    const [userEmail, setUserEmail] = useState<string>('');
    const [userPwd, setuserPwd] = useState<string>('');
    const [userPwdChk, setuserPwdChk] = useState<string>('');
    const [userNickname, setuserNickname] = useState<string>('');
    const [userHp, setuserHp] = useState<string>('');
    const [userAddr, setuserAddr] = useState<string>('');
    const [userAddrDetail, setuserAddrDetail] = useState<string>('');
    const {setAuthView} = props;

    const signUpHandler = async () => {
        const data = { userEmail,
                        userPwd,
                        userPwdChk,
                        userNickname,
                        userHp,
                        userAddr,
                        userAddrDetail
                      };
        const signUpResponse = await signUpApi(data);

        if(!signUpResponse) {
            alert("회원가입에 실패하였습니다.");
            return;
        }

        if(!signUpResponse.result) {
            alert("회원가입에 실패하였습니다.");
            return;
        }

        //조건 다 빠져나오면 성공
        alert("회원가입에 성공하였습니다.");
        setAuthView(false);
    }

  return (
    <Card sx={{ minWidth: 275, maxWidth: "50vh"}}>
        <Box>
            <Typography variant='h5'>회원가입</Typography>
        </Box>
            <Box height='50vh'>
                <TextField fullWidth label="이메일 주소" type ="email" variant="standard" onChange={(e) => setUserEmail(e.target.value)} />
                <TextField fullWidth label="비밀번호" type = "password" variant="standard" onChange={(e) => setuserPwd(e.target.value)} />
                <TextField fullWidth label="비밀번호 확인" type = "password" variant="standard" onChange={(e) => setuserPwdChk(e.target.value)} />
                <TextField fullWidth label="닉네임" variant="standard" onChange={(e) => setuserNickname(e.target.value)} />
                <TextField fullWidth label="휴대폰 번호" variant="standard" onChange={(e) => setuserHp(e.target.value)} />
                <TextField fullWidth label="주소" variant="standard" onChange={(e) => setuserAddr(e.target.value)} />
                <TextField fullWidth label="상세 주소" variant="standard" onChange={(e) => setuserAddrDetail(e.target.value)} />
            </Box>  
            <Box component='div'>
                <Button fullWidth onClick={() => signUpHandler()} variant="contained">회원가입</Button>
            </Box>
            <Box component='div' display='flex' mt={2}>
                <Typography>이미 계정이 있으신가요?</Typography>
                <Typography fontWeight={800} ml={1} onClick={ () => setAuthView(false)}>로그인</Typography>
            </Box>
    </Card>        
  );
}
