class ExtendsDemo2
{
  public static void main(String[] args)
  {
    Zi z1 = new Zi();
    Zi z2 = new Zi("��С˫",28);
    z1.show();
    z2.show();
  }
}

class Fu
{
  protected String _name;
  protected int _age;
  public Fu()
  {}
  public Fu(int age)
  {
    _age = age;
  }
  public void show()
  {
    System.out.println("�ҵ����ֽУ�"+_name+"������"+_age+"�꣡");
  }
}

class Zi extends Fu
{
  public Zi()
  {
    super();
  }
  public Zi(String name,int age)
  {
    super(age);
    this._name = name;
  }
}
