var http = require("http");
http.createServer(function (req, res) {
  res.writeHead(200,{'Content-Type':'text/http;charset=utf-8'});
  res.write('<h1>孙小双的主页</h1>');
  res.write('<h1>等不到天黑</h1>');
  res.end('<p>页脚</p>');
}).listen(8890);
