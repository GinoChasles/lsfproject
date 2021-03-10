import logo from './logo.svg';
import './App.css';
import Testfetch from "./composants/Testfetch.js";
import TestListMot from "./composants/TestListMot";
import NavBar from "./composants/NavBar";
function App() {
  return (
    <div className="App">
      <header className="App-header">
      <NavBar />
      </header>
        {/*<Testfetch />*/}
        <TestListMot />
    </div>
  );
}

export default App;
