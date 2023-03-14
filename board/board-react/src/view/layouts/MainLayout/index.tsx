import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useCookies } from 'react-cookie'
import { useUserStore } from '../../../stores'
import Athentication from '../../Authentication'
import BoardMain from '../../BoardMain'
import Navigation from '../../Navigation'

export default function MainLayout() {
 
  const [boardResponse, setboardResponse] = useState<string>('');
  const [cookies] = useCookies();
  const { user } = useUserStore();
  const getBoard = async (token: string) => {
    const requsetOption = { 
      headers: {
        Authorization: `Bearer ${token}`
      }
    };
    await axios.get('http://localhost:4000/api/board/', requsetOption)
    .then((response) => {
      setboardResponse(response.data);
    })
    .catch((error) => '');
  }

  //user 값 바뀔때마다 실행됨
  useEffect(() => {
    const token = cookies.token;
    if(token)
      getBoard(token);
    else
      setboardResponse('');
  }, [cookies.token]);

  return (
    <>
        <Navigation />
        {user ? (<BoardMain />) : (<Athentication />)}
    </>
  )
}
