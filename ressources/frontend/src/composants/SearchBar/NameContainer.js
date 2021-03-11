import React from "react";

class Name extends React.Component {
    render() {
        return (
            <div >
                {this.props.name}
            </div>
        )
    }
}

export default class NameContainer extends React.Component {
    render() {
        return (
            <div>
                {this.props.names.map(name => <Name name={name} />)}
            </div>
        )
    }
}