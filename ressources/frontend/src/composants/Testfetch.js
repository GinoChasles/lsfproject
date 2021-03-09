import React, {Component} from "react";


export default class Testfetch extends Component {
    constructor(props){
        super(props);
        this.state = {
            topics: []
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/dico/mots/').then((res)=>res.json().then((data)=>{
            this.setState({ topics: data });
        }));
    }

    render() {
        console.log(this.state.topics) //returns [] the first render, returns ['topic1','topic2','topic3'] on the second render;
        return(
            <ul>
                {this.state.topics.map(topic => (
                    <li>{topic.ortho}</li>
                ))}
            </ul>
        )
    }
}