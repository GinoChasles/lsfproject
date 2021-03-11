import React from "react";
import '../CSS/Footer.css'

export default class Footer extends React.Component{
    render(){
        let fullYear = new Date().getFullYear();
        return (
            <div className={"footer"}>
                <p>{fullYear}-{fullYear+1}, Tout droits réservés par LSF4All</p>
            </div>
        )
    }
}