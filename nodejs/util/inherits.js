var util = require('util');
function Base(){
  this.name = 'base';
  this.base = 2016;
  this.sayHello = function () {
    console.log('你好，'+this.name+',现在是'+this.base+'年');
  }
}
Base.prototype.showName = function () {
  console.log(this.name);
}
function Sub() {
  this.name = 'sub';
}
util.inherits(Sub,Base);
var objBase = new Base();
objBase.showName();
objBase.sayHello();
console.log(objBase);
var objSub = new Sub();
objSub.showName();
console.log(objSub);
