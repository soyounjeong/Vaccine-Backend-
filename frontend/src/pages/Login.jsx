import React from "react";
import { Link,BrowserRouter as Router } from "react-router-dom";
import styled from 'styled-components';
import Header from "../components/header";

const LoginPage = () => {

const Login = styled.div`

.container{
    background-color: white;
    width: 50rem;
    margin: 0 auto;
    height: 54.5rem;


    

}
.body{
    background-color: white;
    width: 30rem;
    
    margin: 0 auto;
    padding: 2rem;
}
.login_top input{
    border-radius: 3px;
    width: 100%;
    height: 2.5rem;
    margin-bottom: 0.5rem;
    border: 1px solid lightgray;
    
}
.login_top input:hover{
    border: 1px solid 4FD0D9;
}
button{
    border: 1px solid black;
    border-radius: 3px;
    
}
.signup{
    background: #4FD0D9;
    width: 18rem;
    height: 2.5rem;
    margin-right: 5px;
    color: white; 
    border:0; 


}
.login_btn {
    border:0; 
    background: #4FD0D9;
    width: 100%; 
    height: 50px;
    padding: 1.5rem 0; 
    font-size: 1.4rem; 
    font-weight: bolder;
    color: white; 
    margin-bottom: 5px;
    padding: 0px;
}

.forMar{
    margin-top: 15rem;
}

.CR{
    position:relative;
    top:230px;
    left:70px;
}
`
    return(
        <>
        <Header></Header>
        <Login>
        <div className="container">

        <div className="body">
            <div className="forMar">
                <h2>BSGO</h2>
            </div>
            <form className="Login">
                    <div className="login_top">
                    {/* 아이디 인풋창 */}
                    <p className='login-text'>아이디</p>
                    <input className="login-input" onfocus="this.placeholder=''" placeholder="아이디"/>
                    {/* 비밀번호 인풋 */}
                    <p className='login-text'>비밀번호</p>
                    <input className="login-input" onfocus="this.placeholder=''"  placeholder="비밀번호"type="password"/>
                    </div>
                
                    <div>
                    {/* 로그인버튼 , 회원가입버튼*/}
                    <button className="login_btn" type="submit" >로그인</button>
                    </div>
                    <button  className="login_btn">
                            회원가입
                    </button>
                    
                
                </form>
                <p className="CR">Copyright2021 Team MJRS All rigth reserved</p>
        </div>
        </div>
        </Login>
        </>
    )
}
export default LoginPage;