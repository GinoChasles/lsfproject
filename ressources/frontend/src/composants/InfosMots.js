import React from "react";

const InfosMots = (props) => {

        return(
            <div>
                    <p>genre:{props.genre}</p>
                    <p>nombre:{props.nombre}</p>
                    <p>infos verbales:{props.infover}</p>
            </div>
        )

}

export default InfosMots;