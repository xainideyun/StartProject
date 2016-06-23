function Person() {
  this.name = '孙小双';
  this.toString = function () {
    return this.name;
  }
}
var obj = new Person();
console.log(require('util').inspect(obj, { depth: null,color:'yellow',showHidden:true}));
console.log(require('util').inspect(obj));
