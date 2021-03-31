import React, {useState, useEffect} from "react";

export default function SignSpell(id) {
const [url, setUrl] = useState("test")

   let fetchUrlId = (id) => {
        fetch("http://localhost:8080/dico/alphabet/sign/" + id).then(res => res.json()).then(data=>{data.url=setUrl})
    }

    return (
        <article>
            <img src={fetchUrlId(id)} alt={url}/>
            <p>test signspell componant</p>
        </article>
    )
}