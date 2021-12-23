import logo from './logo.svg';
import './app.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'; //a태그 기능
import LoginPage from './pages/Login';
import RegistPage from './pages/Regist'
import MainPage from './pages/Main'
function App() {
  return (
    <>
    <Router>
      <Routes>
        <Route path={"/"} element={<LoginPage/>}/>    
        <Route path={"/regist"} element={<RegistPage/>}/>  
        <Route path={"/main"} element={<MainPage/>}/>  

      </Routes>
    </Router>
    </>
  );
}

export default App;
