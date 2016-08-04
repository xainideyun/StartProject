class Fu
{
  int num = 1;
}
class Zi extends Fu
{
  int num = 2;
  void show()
  {
    System.out.println("∏∏¿‡£∫" + super.num);
    System.out.println("◊”¿‡£∫" + this.num);
  }
}

class ExtendsDemo1
{
  public static void main(String[] args)
  {
    Zi z = new Zi();
    z.show();
  }
}
