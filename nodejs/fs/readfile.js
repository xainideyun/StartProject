var fs = require('fs');
fs.readFile('file.txt',function (err,data) {
  if (err) {
    console.log(err);
  }
  else {
    console.log(data);  // 没有指定编码，打印二进制
  }
});
fs.readFile('file.txt','utf-8',function (err,data) {
  if (err) {
    console.log(err);
  }
  else {
    console.log(data);  // 打印文件内容
  }
});
