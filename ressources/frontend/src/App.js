import './App.css';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

import ListMots from "./composants/ListMots";
import Home from "./composants/Home";
import MonCompte from "./composants/MonCompte";
import Footer from "./composants/Footer";


function App() {
  return (
      <Router >
          <nav>
              <ul className='nav-menu'>
                  <li>
                      <Link to="/dico/mots" className="nav-links">Dictionnaire</Link>
                  </li>
                  <li>
                      <Link to="/"><img id="logo-nav" src={process.env.PUBLIC_URL + '/img/logo/logo1.png'} alt="logo lsf4all" /></Link>
                  </li>
                  <li>
                      <Link to="/compte" className="nav-links">Mon Compte</Link>
                  </li>
              </ul>
          </nav>
        <main>
          <Switch>
              <Route path="/dico/mots"><ListMots/></Route>
              <Route path="/compte" component={MonCompte}/>
              <Route path="/" component={Home}/>
          </Switch>
        </main>
          <Footer />
      </Router>

  );
}

export default App;
