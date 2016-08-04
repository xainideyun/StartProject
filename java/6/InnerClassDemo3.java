abstract class AbsCls
{
  abstract void show();
}
class Outer
{
  int num = 3;
  class Inner extends AbsCls
  {
    void show()
    {
      System.out.println("我的数字是：" + num);
    }
  }
  void function()
  {
    new Inner().show();
  }
}

class InnerClassDemo3
{
  public static void main(String[] args)
  {
    new Outer().function();     // 输出3
    Outer a = new Outer();
    a.num = 220;
    a.function();               // 输出220
    new Outer().new Inner().show(); // 输出3
  }
}
