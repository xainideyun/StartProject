function compute() {
  console.log('方法1');
}
function somethingCompile(args) {
  console.log('方法2');
}
function dosomething(args,callback) {
  somethingCompile(args);
  process.nextTick(callback);
}
// function dosomething(args,callback) {
//   somethingCompile(args);
//   callback();
// }
dosomething('123456',function () {
  compute();
})
