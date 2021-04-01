import React from 'react';

export default class SignSpellClass extends React.Component {

    constructor(props) {
        super(props);
        this.state=
        {
            url: '',
            word: []
        }}
    componentDidMount() {
        this.fetchUrlId(this.props.props);
    }
/*conversion lettre en chiffre pour fetch*/
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
    }

    render() {
        return (
            <article>
                <img src={process.env.PUBLIC_URL + this.state.url} alt={this.state.url}/>
                <p>test signspell componant</p>
            </article>
        )
    }
}