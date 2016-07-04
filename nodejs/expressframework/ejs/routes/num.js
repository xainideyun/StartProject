var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('我是自己创建的一个视图...');
});

module.exports = router;
