import React from "react";
import { Link,BrowserRouter as Router } from "react-router-dom";
import styled from 'styled-components';
import Header from "../components/header";

const MainPage = () => {

    const Main = styled.div`
    
    .container{
        background-color: white;
        width: 70rem;
        margin: 0 auto;
        height: 51rem;
    }
    .body{
        background-color: white;
        width: 65rem;
        height: 45rem;
        margin: 0 auto;
        padding: 2rem;
        
    }

    .Box{
        display:flex;
        margin-top:8rem;
    }
    .forProfile{
        
        width: 20rem;
        height: 15.5rem;
        margin: 0 auto;

        border: 1px solid lightgray;
        border-radius: 12px; 
        margin-bottom:38px;
    }
    .forNav{
        
        width: 20rem;
        height: 15.5rem;
        margin: 0 auto;

        border: 1px solid lightgray;
        border-radius: 12px; 

    }

    .forReservation{
        float: left;
        width: 40rem;
        height: 33.5rem;
        margin: 0 auto;

        border: 1px solid lightgray;
        border-radius: 12px; 
    }
    .leftBox{
        display: flex;
    flex-direction: column;
    }
    .forSearch input{
        width:35rem;
        height: 2rem;
    }
    .forSearch button{
        width:4.5rem;
        height: 2.3rem;
    }
    `


    return(
    <>
    <Main>

        <div className="container">

            <div className="body">
                <h2>사실 안맞아도 됩니다.람쥐</h2>
                <div className="Box">
                    <div className="leftBox">

                        <div className="forProfile">
                            <div className="info">
                                <p>이재성님 환영합니다</p>
                                <p>1차 접종 완료자 입니다.</p>
                            </div>
                        </div>
                        <div className="forNav">
                            <div className="info">
                                <div className="firstInfo">
                                <p>1차 접종자</p>
                                <p>15,420,444 명</p>
                                </div>
                                <div className="secondInfo">
                                <p>2차 접종자</p>
                                <p>15,420,444 명</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="forReservation">
                        <div className="forSearch">
                            <input placeholder="병원 이름을 검색해보세요!"></input>
                            <button>search</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </Main>
    </>
    )

    
}
export default MainPage;