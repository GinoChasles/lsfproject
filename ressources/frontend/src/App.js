import './App.css';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

import TestListMot from "./composants/TestListMot";
import Home from "./composants/Home";


function App() {
  return (
      <Router>
          <nav>
              <ul className='nav-menu'>
                  <li>
                      <Link to="/dico/mots" className="nav-links">Dictionnaire</Link>
                  </li>
                  <li>
                      <Link to="/home"><img id="logo-nav" src={process.env.PUBLIC_URL + '/img/logo1.png'} alt="logo lsf4all" /></Link>
                  </li>
                  <li>
                      <Link to="/" className="nav-links">Mon Compte</Link>
                  </li>
              </ul>
          </nav>
          <Switch>
              <Route path="/dico/mots"><TestListMot /></Route>
              <Route path="/home" component={Home}></Route>
              <Route path="/"></Route>
          </Switch>
      </Router>

  );
}

export default App;
