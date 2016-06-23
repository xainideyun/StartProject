var http = require('http');
var server = new http.Server();
server.on('request',function (a) {
  a.writeHead(200,{'Content-Type':'text/html'})
  var fs = require('fs');
  fs.readFileSync('../tmpl/index.html','utf-8',function (err,data) {
    a.write(data);
  });
})
server.listen(3000);
console.log('端口3000正在提供服务');
