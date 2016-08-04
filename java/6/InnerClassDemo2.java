class Outer
{
  int num = 2;
  void method()
  {
    class Inner
    {
      void function()
      {
        System.out.println(Outer.this.num);
      }
    }
    new Inner().function();
  }
}

class InnerClassDemo2
{
  public static void main(String[] args)
  {
    new Outer().method();
  }
}
