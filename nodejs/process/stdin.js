process.stdin.resume();   // 恢复流
process.stdin.on('data',function (data) {
  process.stdout.write('我说：'+data.toString());
});
