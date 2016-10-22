import React, {Component} from 'react'
import config from './config.json'
class Module3 extends Component {
	render(){
		return (
			<div>{config.name}</div>
		);
	}
}
export default Module3