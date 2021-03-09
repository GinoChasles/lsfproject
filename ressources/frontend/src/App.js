import logo from './logo.svg';
import './App.css';
import Testfetch from "./composants/Testfetch.js";
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
        <Testfetch />
      </header>
    </div>
  );
}

export default App;
