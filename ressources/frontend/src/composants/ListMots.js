import React from "react";
import '../App.css';
import '../CSS/ListMots.css';
import SignSpell from "./SignSpell";
import SignSpellClass from "./SignSpellClass";

export default class ListMots extends React.Component{

    constructor(props) {
        super(props);
        this.state= {
            mots:[],
            currentPage: 1,
            motsPerPage: 20,
            search: '',
            idMot: 1,
            clicked: null
        };
        this.handleClick = (props) => {
            this.setState({clicked: props});
        };
    }

    componentDidMount() {
        this.findAllMots(this.state.currentPage);
    }

    findAllMots(currentPage){
        currentPage -=1;
        fetch('http://localhost:8080/dico/words/?page=' + currentPage + '&size=' + this.state.motsPerPage).then((res) => res.json().then((data) => {
            this.setState({
                mots: data.content,
                totalPages: data.totalPages,
                totalElements: data.totalElements,
                currentPage: data.number + 1
            });
        }));
    }



    changePage = event => {
        let targetPage = parseInt(event.target.value);

        if(this.state.search){
            this.searchData(targetPage)
        } else {
            this.findAllMots(targetPage);
        }

        this.setState({
            currentPage: targetPage
        });
    }

    firstPage = () => {
        let firstPage = 1;
        if(this.state.currentPage > firstPage) {
            if (this.state.search) {
                this.searchData(firstPage)
            } else {
                this.findAllMots(firstPage);
            }
        }
    }
    prevPage = () => {
        let prevPage = 1;
        if(this.state.currentPage > prevPage){
            if(this.state.search){
                this.searchData(this.state.currentPage - prevPage)
            } else {
                this.findAllMots(this.state.currentPage - prevPage);
            }
        }
    }
    lastPage = () => {
        let condition = Math.ceil(this.state.totalElements / this.state.motsPerPage)
        if(this.state.currentPage < condition) {
            if (this.state.search) {
                this.searchData(condition)
            } else {
                this.findAllMots(condition);
            }
        }
    }
    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.totalElements / this.state.motsPerPage)){
            if(this.state.search){
                this.searchData(this.state.currentPage + 1)
            } else {
                this.findAllMots(this.state.currentPage + 1);
            }

        }
    }

    searchChange = event => {
        this.setState({
            search : event.target.value
        })
    }

    searchData = (currentPage) => {
        currentPage -=1;

        if(this.state.search === ''){
            fetch('http://localhost:8080/dico/words/all/20?page='+currentPage+'&size='+this.state.motsPerPage).then((res)=>res.json().then((data)=>{
                this.setState({
                    mots: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            }));
        } else {
            fetch('http://localhost:8080/dico/words/search/'+this.state.search+'?page='+currentPage+'&size='+this.state.motsPerPage).then((res)=>res.json().then((data)=>{
                this.setState({
                    mots: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            }));
        }
    }
    cancelSearch = () => {
        this.setState({"search":''});
        this.findAllMots(this.state.currentPage);
    }

    notVideo = (mot) => {
        if(mot.video === null || mot.video === undefined ){
            return (
                <div>
                    <img src={process.env.PUBLIC_URL + '/img/icones/ajoutvideo.svg'} alt={'icone ajout vidéo'}
                         onClick={this.ajouterVideo}/>
                    <img src={process.env.PUBLIC_URL + '/img/icones/notvideo.svg'} alt={'icone absence vidéo'}/>
                </div>
            )} else {
            return (
                <div>
                    <img src={process.env.PUBLIC_URL + '/img/icones/video.svg'} alt={'icone vidéo existante'}
                         onClick={this.afficherVideo}/>
                </div>
            )}
    }

    ajouterVideo = () => {
        this.handleClick("ajout")
                // alert("ajouter video?")

    }

    afficherVideo = () => {
        this.handleClick("video")
                // {alert("video existante")}

    }

    notGenre = (mot) => {
        if(mot.gender === null || mot.gender === undefined ){
            return (
                <div>

                </div>
            )} else {
            return (
                <div>
                    {mot.gender.name}
                </div>
            )}
    }

    notNombre = (mot) => {
        if(mot.number === null || mot.number === undefined ){
            return (
                <div>

                </div>
            )} else {
            return (
                <div>
                    {mot.number.name}
                </div>
            )}
    }

    fetchMotParId = (id) => {
        fetch('http://localhost:8080/dico/words/' + id ).then(res => res.json()).then((data) => {
        this.setState({
            idMot: id
        })

    console.log(this.state.idMot)
        })
    }

    render () {

        const {mots, currentPage, totalPages, search} = this.state;

        // const lastIndex = currentPage * motsPerPage;
        // const firstIndex = lastIndex - motsPerPage;
        // const currentMots = mots.slice(firstIndex,lastIndex);
        // const totalPages = Math.round(mots.length / motsPerPage);


        return (
            <section className="page">
                <h1 className = "text-center">Dictionnaire</h1>

                <article className="barre-recherche">
                    <label htmlFor="search" className="visuallyhidden">Mot à rechercher</label>
                    <input type="text" name="search" value={search} onChange={this.searchChange} required minLength="1"/>
                    <button type="button" name="search" onClick={this.searchData}>Rechercher</button>
                    <button type="button" name="cancel" onClick={this.cancelSearch}>Annuler</button>
                </article>

                <article className="pagination">
                    <p>Page {currentPage} sur {totalPages}</p>

                    <button type="button" disabled={currentPage === 1 ? true : false}
                            onClick={this.firstPage}>Première</button>

                    <button type="button" disabled={currentPage === 1 ? true : false}
                            onClick={this.prevPage}>Précédente</button>

                    <label htmlFor="currentPage" className="visuallyhidden">numéro de page</label>
                    <input type="number" name="currentPage" id="currentPage" value={currentPage} max={totalPages} onChange={this.changePage} />


                    <button type="button" disabled={currentPage === totalPages ? true : false}
                            onClick={this.nextPage}>Suivante</button>

                    <button type="button" disabled={currentPage === totalPages ? true : false}
                            onClick={this.lastPage}>Dernière</button>
                </article>


                <table className = "table">
                    <thead>
                    <tr>
                        <td>Orthographe</td>
                        <td> lemme du mot</td>
                        <td> catégorie gramaticale</td>
                        <td> genre</td>
                        <td>  nombre</td>
                        <td>  info verbale</td>
                        <td> nbr de lettres </td>
                        <td> nbr de syllabes </td>
                        <td> ortho renversé </td>
                        <td> vidéo  </td>
                    </tr>

                    </thead>
                    <tbody>
                    {
                        mots.map(
                            mot =>
                                <tr key = {mot.id} onClick={()=>this.fetchMotParId(mot.id)}>
                                    <td> {mot.spelling}</td>
                                    <td> {mot.lemma}</td>
                                    <td> {mot.catgram.name}</td>
                                    <td> {this.notGenre(mot)}</td>
                                    <td> {this.notNombre(mot)}</td>
                                    <td> {mot.infover}</td>
                                    <td> {mot.nbletters}</td>
                                    <td> {mot.nbsyll}</td>
                                    <td> {mot.reverspel}</td>
                                    <td> {this.notVideo(mot)}</td>

                                </tr>
                        )
                    }
                    </tbody>
                </table>

{/*
                {console.log(this.state.idMot)}
*/}

                {this.state.clicked !== "video" ? null : (
                    <div>
                       <p>La vidéo</p>
                        <iframe width="427" height="240" src="https://www.youtube.com/embed/oOiGmbYjwUQ" frameBorder="0"
    allowFullScreen title="vidéo"/>
{/*
                    <SignSpell id={this.state.idMot}/>
*/}
                    <SignSpellClass props={this.state.idMot} />
                    </div>
                )}

                {this.state.clicked !== "ajout" ? null : (
                    <div>
                   <form>
                    <input type={"text"}/>
                    <button type={"submit"}>Envoyer</button>
                   </form>
                    </div>
                )}
            </section>

        )
    }
}