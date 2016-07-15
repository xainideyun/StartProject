var express = require('express');
var router = express.Router();

router.get('/',function (req,res) {
  res.render('tmplengine',{title:'模版引擎页面',subtitle:'说明她的使用方法...'})
});

module.exports = router;
