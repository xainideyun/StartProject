var config = require("./config.json");
module.exports = function(){
	var div = document.createElement("div");
	div.innerHTML = config.name;
	return div;
}