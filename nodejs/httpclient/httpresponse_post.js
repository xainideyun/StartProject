/* get请求的参数解析
var http = require('http');
var querystring = require('querystring');
var url = require('url');
http.createServer(function (req,res) {
  console.log('请求到来！');
  var post=url.parse(req.url,true);
  res.writeHead(200,{'Content-Type':'text/html;charset=utf-8;'})
  res.end(post.query.name);
}).listen(5000);
console.log('端口5000正在提供服务...');
*/

// 创建服务端
var http = require('http');
var querystring = require('querystring');
http.createServer(function (req,res) {
  var post = '';
  req.on('data',function (chunk) {
    post+=chunk;
  });
  req.on('end',function () {
    post=querystring.parse(post);
    res.end(post.name);
  })
}).listen(5000);
console.log('端口5000正在提供服务');

// 客户端请求
var contents = querystring.stringify({
  name:'sunxsh',age:28,code:'2071714117'
});
var options = {
  host:'localhost',
  path:'/',
  port:5000,
  method:'post',
  headers:{
    'Content-Type':'application/x-www-form-urlencoded',
    'Content-Length':contents.length
  }
};
var req = http.request(options,function (res) {
  res.setEncoding('utf-8');
  res.on('data',function (data) {
    console.log('后台返回的数据');
    console.log(data);
  })
});
req.write(contents);
req.end();
