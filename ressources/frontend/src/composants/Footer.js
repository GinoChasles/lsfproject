import React from "react";
import '../CSS/Footer.css'

export default class Footer extends React.Component{
    render(){
        let fullYear = new Date().getFullYear();
        return (
            <footer className="footer">
                <a href="test.html">test</a>
                <p>{fullYear}-{fullYear+1}, Tout droits réservés par LSF4All</p>
            </footer>
        )
    }
}