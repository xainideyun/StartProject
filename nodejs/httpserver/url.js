var http = require('http');
var url = require('url');
var querystring = require('querystring');
var util = require('util');
http.createServer(function (req,res) {
  // res.writeHead(200,{'Content-Type':'text/html;charset=utf-8'})
  /*
    url.parse:
    将url转化为对象
    true:将query封装为对象参数的形式
    false:query以字符串的形式呈现
  */
  // res.write(util.inspect(url.parse(req.url,true)));
  var post = '';
  res.on('data',function (chunk) {
    post+=chunk;
  })

  res.on('end',function () {
    post=querystring.parse(post);
    res.end(util.inspect(post));
  });
}).listen(4000);
console.log('端口4000正在提供服务...');
