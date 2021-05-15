import React from 'react';

export default class SignSpellClass extends React.Component {

    constructor(props) {
        super(props);
        this.state=
        {
            wordList: [],
            idMot:0
        }}
    componentDidMount() {
        this.fetchUrlId(this.props.props);
    }
    componentDidUpdate(prevProps, prevState) {

        if(prevProps.props !== this.props.props){
            this.fetchUrlId( this.props.props)
        }
    }

    fetchUrlId = (id) => {
        fetch("http://localhost:8080/dico/words/" + id).then(res => res.json()).then(data => {
            this.setState({
                wordList: data.spelling.split(""),
                idMot: data.id
            })
        })

    }

    randomId = id => {
        return Math.floor(Math.random() * (100000 - id)) + id
    }
    render() {
        return (
            <article>

                {this.state.wordList.map(el=>{
                   return( <img id={this.randomId(this.state.idMot)} src={process.env.PUBLIC_URL + "/img/alphabet/" + el + ".png"} alt={this.state.url}/>)

                })}
            </article>
        )
    }
}