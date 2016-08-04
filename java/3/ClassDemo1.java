class Person
{
  private int age;
  private String name;
  /*
    构造代码块
  */
  {
    age = 12;
    name = "sunxsh";
  }
  public Person()
  {

  }
  public Person(String name)
  {
    this.name = name;
  }
  public Person(String name,int age)
  {
    this(name);
    this.age = age;
  }
  public void show()
  {
    System.out.println("my name is " + name + ",my old is :" + age + "!");
  }
}


class ClassDemo1
{
  public static void main(String[] args)
  {
    Person p = new Person();
    p.show();
    Person p1 = new Person("lijuanjuan",27);
    p1.show();
  }
}
