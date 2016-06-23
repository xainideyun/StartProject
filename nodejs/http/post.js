var http = require('http');
var querystring = require('querystring');
var util = require('util');
http.createServer(function (req,res) {
  var post = '';
  req.on('data',function (chunk) {  // 解析post请求的参数
    post += chunk;
  });
  req.on('end',function () {
    res.end(util.inspect(querystring.parse(post)));
  });
}).listen(5000);
console.log('端口5000正在提供服务...');
