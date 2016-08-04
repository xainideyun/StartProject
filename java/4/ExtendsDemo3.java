class Fu
{
  int num = 9;
  public void show1()
  {
    System.out.println("fu show1");
  }
  public void show2()
  {
    System.out.println("fu show2");
  }
  public static void show3()
  {
    System.out.println("fu show3");
  }
}
class Zi extends Fu
{
  int num = 99;
  public void show2()
  {
    System.out.println("zi show2");
  }
  public static void show3()
  {
    System.out.println("zi show3");
  }
}
class ExtendsDemo3
{
  public static void main(String[] args)
  {
    Fu z = new Zi();
    z.show1();
    z.show2();
    z.show3();
    System.out.println(z.num);
    z.num = 20;
    System.out.println(z.num);
    System.out.println(((Zi)z).num);
  }
}
