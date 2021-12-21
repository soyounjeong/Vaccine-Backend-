import logo from './logo.svg';
import './app.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'; //a태그 기능
import LoginPage from './pages/Login';
function App() {
  return (
    <>
    <Router>
      <Routes>
        <Route path={"/"} element={<LoginPage/>}/>    
      </Routes>
    </Router>
    </>
  );
}

export default App;
