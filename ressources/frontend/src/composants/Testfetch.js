import React, {Component} from "react";

const url = 'http://localhost:8080/dico/mots/';
const options = {
    method: 'GET',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8'
    }
};

const data = fetch(url, options)
    .then(response => {
        console.log(response.status);
    })

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
        console.log(this.state.topics) //returns [];
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