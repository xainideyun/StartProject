package pack15;
interface MathOperator<T>  {
  T calc(T t1, T t2);
}
class LambdaDemo3{
  public static void main(String[] args) {
    Test t = new Test();
    t.test();

}
class Test{
  void test(){
    MathOperator<Integer> mo = (a ,b) -> a + b;
    int result = mo.calc(3,4);
    System.out.println(result);
  }
}
