abstract class AbsCls
{
  abstract void show();
}
class Outer
{
  int num = 9;
  void function()
  {
    AbsCls obj = new AbsCls()
    {
      void show()
      {
        System.out.println("���������ǣ�" + num);
      }
    };
    obj.show();
  }
}
class InnerClassDemo4
{
  public static void main(String[] args)
  {
    new Outer().function();
  }
}
