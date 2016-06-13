var name;
exports.setName = function(name){
  this.name = name;
};
exports.sayHello = function(){
  console.log("你好" + this.name);
};
function Person(){
  this.name;
  this.setName = function(name){
    this.name = name;
  }
  this.sayHello = function(){
    console.log('还行' + this.name);
  }
}
exports.createPerson = function(){
  return new Person();
};

module.exports = Person;    // 将类直接赋值给对象
