import logo from './logo.svg';
import './App.css';
import Testfetch from "./composants/Testfetch.js";
import TestListMot from "./composants/TestListMot";
function App() {
  return (
    <div className="App">
      <header className="App-header">
               <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        {/*<Testfetch />*/}
        <TestListMot />
      </header>
    </div>
  );
}

export default App;
