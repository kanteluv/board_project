import React, { useState } from 'react'
import SignIn from './SignIn'
import SignUp from './SignUp'
import Box  from '@mui/material/Box'

export default function Authentication() {
  //authview : true - signUp / false - signIn
  const [authView, setAuthView] = useState<boolean>(false);
  return (
    <>    
        <Box display='flex' height='100vh'>
          <Box flex={1} display='flex' justifyContent='center' alignItems='center'>

          </Box>
          <Box flex={1} display='flex' justifyContent='center' alignItems='center'>
            { authView ? (<SignUp setAuthView={setAuthView} />) :  (<SignIn setAuthView={setAuthView} />) }
          </Box>
        </Box>
    </>
  )
}
