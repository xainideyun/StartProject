/*
  第一步：引入模块
*/
var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var routes = require('./routes/index');
var users = require('./routes/users');

 // 实例化express
var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));  // __dirname项目路径
app.set('view engine', 'ejs');                    // 采用ejs视图引擎

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));                           // 以dev的模式打印日志
app.use(bodyParser.json());                       // 解析客户端请求,之后直接公共req.body.name访问参数
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', routes);
app.use('/users', users);

// 自己写的路由
var num = require('./routes/num');
app.use('/num', num);
// 传递querystring
var param = require('./routes/param');  // 第一种方式
app.use('/param', param);
// 模版引擎
app.use('/tmplengine',require('./routes/tmplengine'));
// 使用模板页
app.use('/childpage1',require('./routes/childpage1'));

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers

// development error handler 错误处理，开发者模式
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});




module.exports = app;
