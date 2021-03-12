import React from "react";
import '../App.css';
import SearchBar from "./SearchBar/SearchBar";

export default class TestListMot extends React.Component{

    constructor(props) {
        super(props);
        this.state= {
            mots:[]
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/dico/mots/').then((res)=>res.json().then((data)=>{
            this.setState({ mots: data });
        }));
    }


    render (){
        let videoState = this.state.mots;
        let icone;
  /*  console.log(videoState);*/
        for(let el in videoState){
        if(el.video == null){
             icone =
            <div>
                <img src={process.env.PUBLIC_URL + '/img/ajoutvideo.svg'} alt={'icone ajout vidéo'}  />
                <img src={process.env.PUBLIC_URL + '/img/notvideo.svg'} alt={'icone absence vidéo'}/>
            </div>
        } else
            {
             icone =
                <div>
                    <img src={process.env.PUBLIC_URL + '/img/ajoutvideo.svg'} alt={'icone ajout vidéo'}/>
                    <img src={process.env.PUBLIC_URL + '/img/video.svg'} alt={'icone vidéo existante'}/>
                </div>
            }
        }
        return (
            <div className="page">
                <h1 className = "text-center">Dictionnaire</h1>



                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td>Orthographe</td>
                        <td> lemme du mot</td>
                        <td> catégorie gramaticale</td>
                        {/*<td> genre</td>*/}
                        {/*<td>  nombre</td>*/}
                        <td>  info verbale</td>
                        <td> nbr de lettres </td>
                        <td> nbr de syllabes </td>
                        <td> ortho renversé </td>
                        {/*<td> vidéo  </td>*/}
                    </tr>

                    </thead>
                    <tbody>
                    {
                        this.state.mots.map(
                            mot =>
                                <tr key = {mot.id}>
                                    <td> {mot.ortho}</td>
                                    <td> {mot.lemme}</td>
                                    <td> {mot.catgram.nom}</td>
                                    {/*<td> {mot.genre.id}</td>*/}
                                    {/*<td> {mot.nombre.id}</td>*/}
                                    <td> {mot.infover}</td>
                                    <td> {mot.nblettres}</td>
                                    <td> {mot.nbsyll}</td>
                                    <td> {mot.orthrenv}</td>
                                    {/*<td> {mot.video.id}</td>*/}
                                </tr>
                        )
                    }

                    </tbody>
                </table>
            </div>

        )
    }
}