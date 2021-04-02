import React from 'react';

export default class SignSpellClass extends React.Component {

    constructor(props) {
        super(props);
        this.state=
        {
            url: '',
            word:'',
            wordList: []
        }}
    componentDidMount() {
        this.fetchUrlId(this.props.props);
    }
    fetchUrlId = (id) => {
        fetch("http://localhost:8080/dico/words/" + id).then(res => res.json()).then(data => {
            this.setState({
                word: data.spelling,
                wordList: data.spelling.split("")
            })



            if (data.url === undefined || data.url === null) {
                return (
                    <div>
                        <p>Pas de vidéo disponible</p>
                    </div>
                )
            }
        })
        /*}
        fetchUrlId = (id) => {
            fetch("http://localhost:8080/dico/alphabet/sign/" + id).then(res => res.json()).then(data => {
                this.setState({
                    url: data.url
                })
                if(data.url === undefined || data.url === null){
                    return (
                        <div>
                            <p>Pas de vidéo disponible</p>
                        </div>
                    )
                }
            })
        */
    }
    render() {
        return (
            <article>
                {this.fetchUrlId(this.props.props)}
{/*
                <img src={process.env.PUBLIC_URL + this.state.url} alt={this.state.url}/>
*/}
                {this.state.wordList.map(el=>{
                   return( <img src={process.env.PUBLIC_URL + "/img/alphabet/" + el + ".png"} alt={this.state.url}/>)

                })}
                <p>test signspell componant</p>
            </article>
        )
    }
}