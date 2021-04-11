import React from "react";

export default class Infos extends React.Component {
    constructor(props) {
        super(props);

    }

    render() {
        return (
            <article>
                {
                    this.props.mots.map(mot => {
                        <div key={mot.id}>{mot.lemma}</div>

                    })
                }
            </article>
        )
    }
}