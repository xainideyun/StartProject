class InnerClass
{
  int num = 27;
  class Inner
  {
    void function()
    {
      System.out.println("我的数字是：" + num);
    }
  }
  class Inner2
  {
    private int num = 2;
    void function()
    {
      int num = 5;
      System.out.println("我的外部类的num为：" + InnerClass.this.num);
    }
  }
}
class InnerClassDemo1
{
  public static void main(String[] args)
  {
    // InnerClass.Inner ic = new InnerClass().new Inner();
    // ic.function();
    // InnerClass ic = new InnerClass();
    // ic.new Inner().function();
    InnerClass ic = new InnerClass();
    ic.num = 998;
    ic.new Inner2().function();
  }
}
