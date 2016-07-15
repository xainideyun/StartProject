var express = require('express');
var router = express.Router();

router.get('/:username', function(req, res, next) {
  res.send('获取路由参数...username=' + req.params.username);
});
router.get('/', function(req, res, next) {
  res.send('我请求的是当前控制器的根目录');
});

module.exports = router;
