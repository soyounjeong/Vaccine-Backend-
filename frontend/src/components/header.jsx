import React, {useEffect, useRef, useState} from "react";
import styled from "styled-components"; 
import {Link} from 'react-router-dom';


const HeaderForm = styled.div`
    .header_container{
        border: 1px solid red;
        background-color: rgb(255, 255, 255);
        width: 100px; height: 20rem; 
        display: fixed; justify-content: space-evenly;
        position: fixed;
        top:50px;
        left:380px
    }
    
`;

const Header = () =>{
    return (
        <HeaderForm>
            <div className="header_container">
                <div className="header_box">
                    
                    <div className="logout_box">
                        <img src="icon/outline_account_circle_black_24dp.png"></img>
                        <img src="icon/outline_home_black_24dp.png"></img>
                        <img src="icon/outline_logout_black_24dp.png"></img>
                    </div>
                </div>
            </div>
        </HeaderForm>
    );
} 

export default Header;