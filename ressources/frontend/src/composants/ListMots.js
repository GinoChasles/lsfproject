import React from "react";
import '../App.css';
import '../CSS/ListMots.css';
import InfosMots from "./InfosMots";

export default class ListMots extends React.Component{

    constructor(props) {
        super(props);
        this.state= {
            mots:[],
            currentPage: 1,
            motsPerPage: 20,
            search: ''
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

    render () {

        const {mots, currentPage, totalPages, search} = this.state;

        return (
            <section className="page">
                <h1 className = "text-center">Dictionnaire</h1>

                <article className="barre-recherche">
                    <label htmlFor="search" className="visuallyhidden">Mot à rechercher</label>
                    <input type="text" name="search" value={search} onChange={this.searchChange} required minLength="1"/>
                    <button type="button" name="search" onClick={this.searchData}>Rechercher</button>
                    <button type="button" name="cancel" onClick={this.cancelSearch}>Annuler</button>
                </article>


                    <InfosMots mots={mots} />


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


            </section>

        )
    }
}