var fs = require('fs');
fs.open('file.txt','r',function(err,fd){  // 使用只读的方式打开文件
  if (err) {
    console.log(err);
    return;
  }
  var buf = new Buffer(8);
  /*
    fd:文件描述
    buf:定义一个缓存对象，每次读取8个字节，保存在该对象里
    offset:文件到buffer的偏移量
    length:一次读取8个字节
    null:以当前的指针读取
  */
  fs.read(fd,buf,0,8,null,function (err,bytesRead,buffer) {
    /*
      err:读取完成后的返回信息
      bytesRead:读到了多少个字节
      buffer:读到文件buffer数组
    */
    if (err) {
      console.log(err);
      return;
    }
    console.log('bytesRead:' + bytesRead);
    console.log(buffer);
  })
})
