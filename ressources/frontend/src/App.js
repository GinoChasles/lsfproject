import './App.css';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

import TestListMot from "./composants/TestListMot";
import SearchBar from "./composants/SearchBar/SearchBar";
import Home from "./composants/Home";
import MonCompte from "./composants/MonCompte";
import Footer from "./composants/Footer";



function App() {
  return (
      <Router>
          <nav>
              <ul className='nav-menu'>
                  <li>
                      <Link to="/dico/mots" className="nav-links">Dictionnaire</Link>
                  </li>
                  <li>
                      <Link to="/"><img id="logo-nav" src={process.env.PUBLIC_URL + '/img/logo1.png'} alt="logo lsf4all" /></Link>
                  </li>
                  <li>
                      <Link to="/compte" className="nav-links">Mon Compte</Link>
                  </li>
              </ul>
          </nav>
          <Switch>
              <Route path="/dico/mots"><SearchBar/> <TestListMot/></Route>
              <Route path="/compte" component={MonCompte}></Route>
              <Route path="/" component={Home}></Route>
          </Switch>
          <Footer />
      </Router>

  );
}

export default App;
