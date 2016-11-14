var user = {};
user.name = '孙小双';
user.show = function(){
	alert(this.name);
};

module.exports = user;