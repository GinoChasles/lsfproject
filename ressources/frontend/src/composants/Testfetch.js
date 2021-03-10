import React, {Component} from "react";


export default class Testfetch extends Component {
    constructor(props){
        super(props);
        this.state = {
            topics: []
        }
        // let getProps = props.location.search;
    }

    componentDidMount() {
        fetch('http://localhost:8080/dico/mots/').then((res)=>res.json().then((data)=>{
            this.setState({ topics: data });
        }));
    }
    // extractParamsUrl(chaineGET)
    // {
    //     chaineGET = chaineGET.split('&');
    //     let result = {};
    //
    //     chaineGET.forEach(function(el){
    //         let param = el.split('=');
    //         param[0] = param[0].replace('?', '');
    //         result[param[0]] = param[1];
    //     });
    //
    //     return result;
    // }

    extractUrlParams(){
        let t = window.location.search.substring(1).split('&');
        let f = [];
        for (let i=0; i<t.length; i++){
            let x = t[ i ].split('=');
            f[x[0]]=x[1];
        }
        return f;
    }

    render() {
        console.log(this.state.topics) //returns [] the first render, returns ['topic1','topic2','topic3'] on the second render;
        console.log(this.extractUrlParams())
        return(
            <ul>
                {this.state.topics.map(topic => (
                    <li>{topic.ortho}</li>
                ))}
            </ul>
        )
    }
}