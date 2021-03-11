import React from "react";
import NameContainer from "./NameContainer";

export default class SearchBar extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            orthos: ['test','test2','bidon','react'],
            searchOrtho: '',
        }
    }
/*
    componentDidMount() {
        fetch('http://localhost:8080/dico/mots/').then((res)=>res.json().then((data)=>{
            this.setState({ orthos: data});
        }));
    }*/

    editSearchOrtho = (e) => {
        this.setState({searchOrtho: e.target.value})
    }
    dynamicSearch = () => {
        return this.state.orthos.filter(el => el.toLowerCase().includes(this.state.searchOrtho.toLowerCase()))
    }

    render()
    {
        return (
            <div>
{/*
            {console.log(this.state.orthos)}
*/}
                <input type="text" value={this.state.searchOrtho} onChange={this.editSearchOrtho} placeholder="Rechercher un mot"/>
                <NameContainer names={this.dynamicSearch()} id={this.props.id} />
            </div>
        )
    }



}