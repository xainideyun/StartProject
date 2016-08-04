/**
  内部静态类
*/
class Outer
{
  int num = 9;
  static class InnerStaticCls
  {
    int num = 20;
    void function()
    {
      System.out.println("我的数字是：" + num);
    }
  }
}
class InnerStaticDemo1
{
  public static void main(String[] args)
  {
    new Outer.InnerStaticCls().function();
    new OuterStaticCls().function();
  }
}
