
class SingleDemo
{
  private SingleDemo(){}
  private static SingleDemo single = new SingleDemo();
  public static SingleDemo getInstance()
  {
    return single;
  }
}

class Demo1
{
  public static void main(String[] args)
  {
    SingleDemo s1 = SingleDemo.getInstance();
    SingleDemo s2 = SingleDemo.getInstance();
    System.out.println(s1);
    System.out.println(s2);
  }
}
