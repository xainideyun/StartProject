module.exports = function(){
	var div1 = document.createElement("div");
	var div2 = document.createElement("div");
	div1.innerHTML = "你还在吗";
	div1.appendChild(div2);
	div2.innerHTML = '你就是屌丝，说什么脑别离';
	return div1;
}