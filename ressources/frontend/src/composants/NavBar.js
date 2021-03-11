import React, { Component } from 'react'

import "../CSS/NavBar.css"

export default class NavBar extends Component {


    render() {
        return (
            <div>
                <ul className='nav-menu'>
                            <li>
                                <a className="nav-links" href="#">Dictionnaire</a>
                            </li>
                             <li><img id="logo-nav" src={process.env.PUBLIC_URL + '/img/logo1.png'} alt="logo lsf4all" /></li>
                            <li>
                                <a className="nav-links" href="#">MonCompte</a>
                            </li>
                </ul>
            </div>
        )
    }
}
