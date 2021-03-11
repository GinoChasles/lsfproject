import React from 'react';
import '../App.css';
import '../CSS/Home.css';
export default function Home() {
    return(
        <div className={"page"} id={"page-home"}>
            <img id="logo-home" src={process.env.PUBLIC_URL + '/img/logo2.png'} alt="logo lsf4all" />
            <p>Le but de se projet est de facilité la traduction de mots français en langue des signes françaises (LSF). <br/> LSF4All se voit comme un projet collaboratif faisant confiance à ses membres sur la traduction effectuée. <br/> Pour cela toute personne, membre du site, peut ajouter une traduction vidéo d'un mot. </p>
        </div>
    )

}