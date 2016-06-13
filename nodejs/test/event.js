// 声明事件对象
var EventEmitter = require('events').EventEmitter;
var event = new EventEmitter();
// 注册事件
event.on('some_event',function(){
  console.log('自定义事件');
});
// 触发事件
setTimeout(function(){
  event.emit('some_event');
},1000);
console.log('等待中');
setInterval(function(){
  event.emit('some_event');
},1000);
