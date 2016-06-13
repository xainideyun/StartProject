var fs = require('fs');
fs.readFile('sunxsh.txt','UTF-8',function(err,data){
  if(err){
    console.log('read File err');
  }
  else {
    console.log(data);
  }
});
console.log('end');
