import React from "react";

export default class InfosMots extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            mot: [],
            id: this.props.id
        }
    }

    fetchMotParId = () => {
        fetch("http://localhost:8080/dico/mots/" + this.state.id ).then(res => res.json()).then((data) => {
            this.setState({
                mot:data
            })
            console.log(data.id)
            console.log(this.mot)
            console.log(this.state.id)
        })
    }

    render()
    {
        return(
            <div className={"infos-mots"}>
                {/*<p>genre:{this.state.mot.genre}</p>*/}
                <p>nombre:{this.state.mot.nombre}</p>
                <p>infos verbales:{this.props.mot.ortho}</p>
                <p>testteststestestes</p>
            </div>
        )
    }
}
