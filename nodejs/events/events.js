var events = require('events');
var emitter = new events.EventEmitter();    // 实例化事件对象
emitter.on('sunxshEvent',function (name,age) {
  console.log("我的名字是",name,',','今年',age,'岁');
});     // 注册事件监听
emitter.on('sunxshEvent',function (name,age) {
  console.log("我是20717141班的",name,',','学号是',age);
});
emitter.emit('sunxshEvent','孙小双',28); // 触发事件
emitter.emit('sunxshEvent','孙小双',28); // 触发事件
