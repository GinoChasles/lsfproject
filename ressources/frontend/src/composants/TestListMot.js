import React from "react";
import '../App.css';
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
    console.log(videoState);
        for(let el in videoState){
        if(el.video == null){
             icone =
            <div>
                <img src={process.env.PUBLIC_URL + '/img/ajoutvideo.svg'}  />
                <img src={process.env.PUBLIC_URL + '/img/notvideo.svg'}/>
            </div>
        } else
            {
             icone =
                <div>
                    <img src={process.env.PUBLIC_URL + '/img/ajoutvideo.svg'}/>
                    <img src={process.env.PUBLIC_URL + '/img/video.svg'}/>
                </div>
            }
        }
        return (
            <div className="page">
                <h1 className = "text-center">Dictionnaire</h1>
                <table className = "table table-striped">
                    <thead>
                    <tr>

                        <td> id du mot</td>
                        <td> orthographe du mot</td>
                        <td> vidéo</td>
                    </tr>

                    </thead>
                    <tbody>
                    {
                        this.state.mots.map(
                            mot =>
                                <tr key = {mot.id}>
                                    <td> {mot.id}</td>
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