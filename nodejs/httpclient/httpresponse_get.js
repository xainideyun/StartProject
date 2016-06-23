var http = require('http');
var url = require('url');
// 启动服务
http.createServer(function (req,res) {
  var params = url.parse(req.url,true);
  res.end(params.query.name);
}).listen(5000);
console.log('服务启动...');

http.get({
  host:'localhost',
  path:'/user?name=孙小双&age=28',
  port:5000
},function (res) {
  res.setEncoding('utf-8');
  res.on('data',function (data) {
    console.log('返回的数据是:'+data);
  });
});
