import React, { useState, Component } from "react";
import { Link,BrowserRouter as Router } from "react-router-dom";
import styled from 'styled-components';
import Header from "../components/header";
import Daum from "../components/daumPostCode"

import DaumPostcode from 'react-daum-postcode';
import PopupDom from '../components/PopupDom';
import PopupPostCode from '../components/PopupPostCode';

const RegistPage = (props) => {
    let emailDisable = false;
    let passwordDisable = false;
    let nameDisable = false;
    let hpDisable = false;
const Regist = styled.div`
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

input, textarea, button { padding: 0; outline: 0; border: 0; resize: none; border-radius: 0; -webkit-appearance: none; background-color: 4FD0D9; }

.forregi input{
    background-color: white;
    border-bottom: 1px solid lightgray;
    height: 2rem;
    color: #222;
    border-left: none;
    border-right: none;
    margin-bottom: 1rem;
    font-size: 1.3rem;
    width:100%
}
.topnav{
    margin-top: 100px;
}
.activebtn {
    border:0; 
    background: #4FD0D9;
    width: 100%; 
    height: 50px;
    padding: 1.5rem 0; 
    font-size: 1.3rem; 
    font-weight: bolder;
    color: white; 
    margin-bottom: 5px;
    padding: 0px;
}

.activebtn button:disabled{ background: #dfdfdf; }

.choiceGender{
    width: 100px;
    height: 30px;
    margin-bottom: 5rem;
}
`
console.log(props.data)
const formRef = React.createRef();

const [email, setEmail] = React.useState('')
const [password, setPassword] = React.useState('')
const [age, setAge] = React.useState('')
const [address1, setAddress1] = React.useState('')
const [address2, setAddress2] = React.useState('')
const [first, setFirst] = React.useState('')
const [second, setSecond] = React.useState('')


const [isOpenPost, setIsOpenPost] = useState(false);

const [name,setName] = React.useState('')
const [hp,setHp] = React.useState('')
const [gender,setGender] = React.useState('남')

//에러메세지 온오프
const [display, setDisplay] = useState("none")
const [display2, setDisplay2] = useState("none")
const [display3, setDisplay3] = useState("none")
const [display4, setDisplay4] = useState("none")
const [display5, setDisplay5] = useState("none")
const [display6, setDisplay6] = useState("none")
const [display7, setDisplay7] = useState("none")



const changeDispaly = (display) => {
    setDisplay(display)
}
const changeDispaly2 = (display2) => {
    setDisplay2(display2)
}
const changeDispaly3 = (display3) => {
    setDisplay3(display3)
}
const changeDispaly4 = (display4) => {
    setDisplay4(display4)
}
const changeDispaly5 = (display4) => {
    setDisplay5(display5)
}
const changeGender = (gender) => {
    setGender(gender)
}


 //정규식 체크
const checkId = (e) => {
    e.preventDefault();

    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
    // 형식에 맞는 경우 true 리턴
    const idV = e.target.value;
    setEmail(idV)

    if (regExp.test(e.target.value) === false) {
        changeDispaly("block")
        emailDisable = false
    } else {
        changeDispaly("none")
        emailDisable = true
    }
    idDisabled()

}
///비밀번호 유효성 검사
const checkPassword = (e) => {
    e.preventDefault();
    //  8 ~ 10자 영문, 숫자 조합
    var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/
    // 형식에 맞는 경우 true 리턴
    const pwV = e.target.value;
    setPassword(pwV)
    if (regExp.test(e.target.value) === false) {
        changeDispaly2("block")
        
        passwordDisable = false
    } else {
        changeDispaly2("none")
        passwordDisable = true
    }
    idDisabled()

}

const checkAge = (e) => {
    e.preventDefault();

    var regExp = /^[0-9]$/

    const ageV = e.target.value;
    setAge(ageV)
    if (regExp.test(e.target.value) === false) {
        changeDispaly5("block")
        
        passwordDisable = false
    } else {
        changeDispaly5("none")
        passwordDisable = true
    }
}
//한글이름 유효성 검사
const checkName = (e) => {
    e.preventDefault();
    var regExp = /^[가-힣]{2,15}$/;
    const pwV = e.target.value;
    setName(pwV)
    if (regExp.test(e.target.value) === false) {
        changeDispaly3("block")
        nameDisable = false
    } else {
        changeDispaly3("none")
        nameDisable = true
    }
    idDisabled()

}
//핸드폰버노 유효성 검사
const checkPh = (e) => {
    e.preventDefault();
    var regExp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
    const pwV = e.target.value;
    setHp(pwV)
    if (regExp.test(e.target.value) === false) {
        changeDispaly4("block")
        hpDisable = false
    } else {
        changeDispaly4("none")
        hpDisable = true
    }
    idDisabled()

}
const checkGender = (e) => {
    e.preventDefault();

    console.log(e.target.value)
    if(e.target.value == 1){
        changeGender("남")
    }else{
        changeGender("여")
    }
}
//버튼활성화
const [disabled, setDisabled ] = React.useState('disabled');

const idDisabled = () => {
    if(emailDisable===true&&passwordDisable===true&&nameDisable===true&&hpDisable===true){
        setDisabled('');
    }else{
        setDisabled('disabled');
    }
}





    return(
        <>
        
        <Regist>
            <div className="container">
                <div className="body">

                <div className="topnav">
                    <div className="topInfo">
                    </div>
                    <h2>회원 가입</h2>
                    <h4>정확한 본인 확인을 위해 올바른 정보를 기입해주세요.</h4>
                </div>

                <form className="forregi" ref={formRef}>
                    <div className="forheigth">
                        <input id="email"  placeholder="아이디" />
                        <p className="red" style={{ display: display }}>* 아이디 양식을 확인해주세요.</p>
                    </div>
                    <div className="forheigth">
                        <input id="pw" onChange={checkPassword} placeholder="비밀번호" type="password" />
                        <p className="red" style={{ display: display2 }}>* 영문,숫자,특수문자 포함 8자 이상 입력해주세요.</p>
                    </div>
                    <div className="forheigth">
                        <input id="age" onChange={checkAge} placeholder="나이" type="text"/>
                        <p className="red" style={{ display: display5 }}>* 만18세 이하는 접종이 불가합니다.</p>
                    </div>
                    <div className="forheigth">
                        <input id="koreaName" onChange={checkName} placeholder="이름" />
                        <p className="red" style={{ display: display3 }}>* 한글 2글자 이상 입력해주세요.</p>
                    </div>
                    <div className="forheigth">
                        <input id="ph" onChange={checkPh} placeholder="휴대폰번호" />
                        <p className="red" style={{ display: display4 }}>* 전화번호를 다시 입력해 주세요. ('-'제외)</p>
                    </div>
                    <p>상세 주소</p>
                    <Daum></Daum>
                    <div className="forheigth">
                        <input id="address1"/>
                        <input id="address2"  placeholder="상세주소" />
                    </div>
                    
                    <div>
                    <select className="choiceGender" onChange={checkGender}>
                        <option value="1">남성</option>
                        <option value="2">여성</option>
                    </select>
                    </div>
                    
                            <button className="activebtn" type="button"
                                disabled={disabled}>
                                회원가입
                            </button>
                    
                </form>

                </div>
            </div>
        </Regist>
        </>
    )
}
export default RegistPage;