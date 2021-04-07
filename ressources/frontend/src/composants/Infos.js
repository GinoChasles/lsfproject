import React, { useState } from 'react';

export default function Infos(props) {
    const donnees = [props.catgram.name,props.infover,props.nbletters,props.nbsyll,props.reverspel]
    const [infos, setInfos] = useState(donnees);

    return (
        <article>
            {infos}
            <button onClick={()=> setInfos(props)}></button>
        </article>
    )
}