// 引入模块
var http = require('http');
// 创建服务
var server = http.createServer(function (req,res) {
  console.log(req.url);
  /*
    一般action都是在这里定义
    .
    .
    .
  */
  // 响应头
  // res.writeHead(200,{'Content-Type':'text/html;charset=utf-8'});
  // // 响应内容
  // res.write('<h3>我的主页</h3>')
  // // 响应结束
  // res.end('<p>页脚copyrigte</p>');
  // server.close();

  res.writeHead(200,{'Content-Type':'text/html'})
  var fs = require('fs');
  fs.readFileSync('../tmpl/index.html','utf-8',function (err,data) {
    res.write(data);
    res.end();
  });
}).listen(5000);

server.on('close',function (a,b,c) {
  console.log("=====================================");
  console.log(a);
  console.log(b);
  console.log(c);
  console.log("=====================================");
});
// server.close();
console.log('服务器已经在端口5000启动...');
