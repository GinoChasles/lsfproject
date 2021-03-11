import React from "react";
import '../App.css';
import SearchBar from "./SearchBar/SearchBar";
import TestSearchBar from "./SearchBar/TestSearchBar";

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
              {/*  <SearchBar/>
                <TestSearchBar />*/}
                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td> orthographe du mot</td>
                        <td> vidéo</td>
                    </tr>

                    </thead>
                    <tbody>
                    {
                        this.state.mots.map(
                            mot =>
                                <tr key = {mot.id}>
                                    <td> {mot.ortho}</td>
                                    <td> {icone}</td>
                                </tr>
                        )
                    }

                    </tbody>
                </table>

            </div>

        )
    }
}