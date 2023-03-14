import { useState } from "react";
import { useCookies } from 'react-cookie';
import { useUserStore } from "../../../stores";
import { signInApi } from "../../../apis";

import Box from '@mui/material/Box';
import { Button,
         Card,
         TextField,
         Typography } from "@mui/material";

interface Props {
    setAuthView: (AuthView: boolean) => void, 
}

export default function SignIn(props: Props) {
    const [userEmail, setUserEmail] = useState<string>('');
    const [userPwd, setuserPwd] = useState<string>('');
    const [cookies, setCookies] = useCookies();
    const {user, setUser} = useUserStore();

    const {setAuthView} = props;

    const signInHandler = async () => {
    if(userEmail.length == 0 || userPwd.length == 0) {
        alert('이메일과 비밀번호를 입력하세요')
        return;
    }

    const data = {
            userEmail,
            userPwd
    };
    
    const signInResponse = await signInApi(data);

    if(!signInResponse) {
        alert('로그인에 실패했습니다.');
        return;
    };

    if(!signInResponse.result) {
        alert('로그인에 실패했습니다.');
        return;
    };

    const {token, exprTime, user } = signInResponse.data;
    const expires = new Date();
    expires.setMilliseconds(expires.getMilliseconds() + exprTime);

    setCookies('token', token, { expires} );
    setUser(user);

        //apis로 대체된 부분
    // await axios.post('http://localhost:4000/api/auth/signIn', data)
    // .then((response) => {
    //     const responseData = response.data;
    //     if(!responseData.result) {
    //         console.log("로그인에 실패함");
    //         return;
    //     }
    //     const {token, exprTime, user } = responseData.data;
    //     const expires = new Date();
    //     expires.setMilliseconds(expires.getMilliseconds() + exprTime);
    //     setCookies('token', token, { expires} );
    //     setUser(user);
    //     // alert(cookies.token);   
    //     console.log(response.data);
    // })
    // .catch((error) => {
    //     alert('로그인에 실패했습니다.');
    // });
    }

  return (
    <Card sx={{ minWidth: 275, maxWidth: "50vh", padding: 5}}>
        <Box>
            <Typography variant='h5'>로그인</Typography>
        </Box>
            <Box height={'50vh'}>
            <TextField fullWidth label="이메일 주소" type ="email" variant="standard" onChange={(e) => setUserEmail(e.target.value)} />
            <TextField fullWidth label="비밀번호" type = "password" variant="standard" onChange={(e) => setuserPwd(e.target.value)} />
            </Box>
            <Box component='div'>
                <Button fullWidth onClick={() => signInHandler()} variant="contained">로그인</Button>
            </Box>
            <Box component='div' display='flex' mt={2}>
                <Typography>신규 사용자 이신가요?</Typography>
                <Typography fontWeight={800} ml={1} onClick={() => setAuthView(true)}>회원가입</Typography>
            </Box>
    </Card>        
  )
}
