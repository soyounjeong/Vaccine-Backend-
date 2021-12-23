import React, { useState, Component } from "react";
import DaumPostcode from "react-daum-postcode";
import RegistPage from "../pages/Regist";
const PopupPostCode = (props) => {

    const [address, setAddress] = useState(''); // 주소
    const [addressDetail, setAddressDetail] = useState(''); // 상세주소

	// 우편번호 검색 후 주소 클릭 시 실행될 함수, data callback 용
    const handlePostCode = (data) => {
        let fullAddress = data.address;
        let extraAddress = ''; 
        
        if (data.addressType === 'R') {
        if (data.bname !== '') {
            extraAddress += data.bname;
        }
        if (data.buildingName !== '') {
            extraAddress += (extraAddress !== '' ? `, ${data.buildingName}` : data.buildingName);
        }
        fullAddress += (extraAddress !== '' ? ` (${extraAddress})` : '');
        }
        console.log(data)
        console.log(fullAddress)
        setAddress(fullAddress)
        console.log(data.zonecode)
        setAddressDetail(data.zonecode)
        props.onClose()
    }

    const postCodeStyle = {
        display: "block",
        position: "absolute",
        top: "10%",
        left: "65%",
        width: "600px",
        height: "600px",
        padding: "7px",
        border: "2px solid black"
    };

    return(
        <>
        
            <DaumPostcode style={postCodeStyle} onComplete={handlePostCode} />
            
            <button type='button' onClick={() => {props.onClose()}} className='postCode_btn'>닫기</button>
            
        </>
        
        
    )
}

export default PopupPostCode;