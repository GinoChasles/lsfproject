import React from "react";

export default class InfosMots extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            mot: [],
            id: this.props.id
        }
    }

    fetchMotParId = (id) => {
        fetch("http://localhost:8080/dico/words/" + id ).then(res => res.json()).then((data) => {
            this.setState({
                mot:data
            })
        })
    }

    render()
    {
        return(

                {
                    this.mot.map(
                        mot =>
                            <tr key = {mot.id} onClick={()=>this.fetchMotParId(mot.id)}>
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
        )
    }
}
