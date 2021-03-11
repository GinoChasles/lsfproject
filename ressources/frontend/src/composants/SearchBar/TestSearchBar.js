import React, { Component } from 'react';


let Information = [];

fetch('http://localhost:8080/dico/mots/').then((res)=>res.json().then((data)=>{
    Information= data;}))

export default class TestSearchBar extends Component {

    constructor(props){
        super(props);

        this.state={
            search:null
        };
    }

    searchSpace=(event)=>{
        let keyword = event.target.value;
        this.setState({search:keyword})
    }



    render(){

        const items = Information.filter((data)=>{
            if(this.state.search == null)
                return data
            else if(data.id.toLowerCase().includes(this.state.search.toLowerCase()) || data.ortho.toLowerCase().includes(this.state.search.toLowerCase())){
                return data
            }
        }).map(data=>{
            return(
                <div>
                    <ul>
                        <li style={{position:'relative',left:'10vh'}}>
                            <span>{data.id}</span>
                            <span>{data.ortho}</span>
                        </li>
                    </ul>
                </div>
            )
        })

        return (
            <div>
                <input type="text" placeholder="Enter item to be searched"  onChange={(e)=>this.searchSpace(e)} />
                {items}
            </div>
        )
    }
}
