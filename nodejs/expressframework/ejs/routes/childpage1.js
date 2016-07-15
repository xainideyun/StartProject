var express = require('express');
var router = express.Router();
router.get('/',function (req,res,next) {
  res.render('childpage1',{name:'李娟娟'})
});

module.exports = router;
