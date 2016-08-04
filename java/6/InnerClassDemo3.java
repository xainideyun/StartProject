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
      System.out.println("�ҵ������ǣ�" + num);
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
    new Outer().function();     // ���3
    Outer a = new Outer();
    a.num = 220;
    a.function();               // ���220
    new Outer().new Inner().show(); // ���3
  }
}
