import React from "react";
import NameContainer from "./NameContainer";

export default class SearchBar extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            orthos: [],
            searchOrtho: '',
            renv: [],

        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/dico/mots/').then((res)=>res.json().then((data)=>{
            this.setState({
                orthos: data.map((item)=>item.ortho),
                renv: data.map((el)=>el.infover)
            });

        }));
    }
    editSearchOrtho = (e) => {
        this.setState({searchOrtho: e.target.value})
    }
    dynamicSearch = () => {
        return this.state.orthos.filter(el => el.toLowerCase().includes(this.state.searchOrtho.toLowerCase()))
    }

    render()
    {
        console.log(this.state.renv)
        return (
            <div className={"page"}>
                <input type="text" value={this.state.searchOrtho} onChange={this.editSearchOrtho} placeholder="Rechercher un mot"/>
                <NameContainer names={this.dynamicSearch()} id={this.props.id} />
                <div>
                </div>
            </div>
        )
    }



}