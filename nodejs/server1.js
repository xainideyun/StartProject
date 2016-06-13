var http = require("http");
http.createServer(function(req,res){
  res.writeHead(200,{'Content-Type':'text/html'})
  res.write('<h3>孙小双的主页</h3>')
  res.end('<p>等不到天黑你妹的</>')
}).listen(7000);
