import React from "react";
import SignSpellClass from "./SignSpellClass";

export default class InfosMots extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            mots: [],
            id: this.props.id,
            clicked: null,
            idMot:1
        }

        this.handleClick = (e) => {
            this.setState({clicked: e});
        };
    }

    // fetchMotParId = (id) => {
    //     fetch("http://localhost:8080/dico/words/" + id ).then(res => res.json()).then((data) => {
    //         this.setState({
    //             mot:data,
    //             idMot:id,
    //         })
    //     })
    // }
    notNombre = (mot) => {
        if(mot.number === null || mot.number === undefined ){
            return (
                <div>

                </div>
            )} else {
            return (
                <div>
                    {mot.number.name}
                </div>
            )}
    }

    notGenre = (mot) => {
        if(mot.gender === null || mot.gender === undefined ){
            return (
                <div>

                </div>
            )} else {
            return (
                <div>
                    {mot.gender.name}
                </div>
            )}
    }
    notVideo = (mot) => {
        if(mot.video === null || mot.video === undefined ){
            return (
                <div>
                    <img src={process.env.PUBLIC_URL + '/img/icones/ajoutvideo.svg'} alt={'icone ajout vidéo'}
                         onClick={this.ajouterVideo}/>
                    <img src={process.env.PUBLIC_URL + '/img/icones/notvideo.svg'} alt={'icone absence vidéo'}/>
                </div>
            )} else {
            return (
                <div>
                    <img src={process.env.PUBLIC_URL + '/img/icones/video.svg'} alt={'icone vidéo existante'}
                         onClick={this.afficherVideo}/>
                </div>
            )}
    }

    ajouterVideo = () => {
        this.handleClick("ajout")
        // alert("ajouter video?")

    }

    afficherVideo = () => {
        this.handleClick("video")
        // {alert("video existante")}

    }


    render()
    {
        return(
            <article>
            <table className = "table">
                <thead>
                <tr>
                    <th scope={"col"}>Orthographe</th>
                    <th scope={"col"}> lemme du mot</th>
                    <th scope={"col"}> catégorie gramaticale</th>
                    <th scope={"col"}> genre</th>
                    <th scope={"col"}>  nombre</th>
                    <th scope={"col"}>  info verbale</th>
                    <th scope={"col"}> nbr de lettres </th>
                    <th scope={"col"}> nbr de syllabes </th>
                    <th scope={"col"}> ortho renversé </th>
                    <th scope={"col"}> vidéo  </th>
                </tr>

                </thead>
    <tbody>
                {
                    this.props.mots.map(
                        mot =>
                            <tr key = {mot.id} onClick={()=>this.setState({idMot: mot.id})} >
                                <td> {mot.spelling}</td>
                                <td> {mot.lemma}</td>
                                <td> {mot.catgram.name}</td>
                                <td> {this.notGenre(mot)}</td>
                                <td> {this.notNombre(mot)}</td>
                                <td> {mot.infover}</td>
                                <td> {mot.nbletters}</td>
                                <td> {mot.nbsyll}</td>
                                <td> {mot.reverspel}</td>
                                <td> {this.notVideo(mot)}</td>

                            </tr>
                    )
                }
    </tbody>
            </table>
                {/*<button type={"button"} onClick={}>Bouton</button>*/}
                <article>
                    {this.state.clicked !== "video" ? null : (
                        <article>
                            <p>La vidéo</p>
                            <iframe width="427" height="240" src="https://www.youtube.com/embed/oOiGmbYjwUQ" frameBorder="0"
                                    allowFullScreen title="vidéo"/>


                            <SignSpellClass props={this.state.idMot} />

                        </article>
                    )}

                    {this.state.clicked !== "ajout" ? null : (
                        <article>
                            <form>
                                <label>text</label>
                                <input type={"text"}/>
                                <button type={"submit"}>Envoyer</button>
                            </form>
                            <SignSpellClass props={this.state.idMot} />

                        </article>
                    )}
                </article>
            </article>
        )
    }
}
