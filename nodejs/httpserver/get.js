//  get请求的参数解析
var http = require('http');
var url = require('url');
http.createServer(function (req,res) {
  res.writeHead(200,{'Content-Type':'text/plain;charset=utf-8;'})
  res.write(require('util').inspect(url.parse(req.url,true)));
  res.end();
}).listen(5000);
console.log('端口5000正在提供服务...');
