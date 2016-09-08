package pack11;
import java.util.*;
class CollectionDemo7
{
  public static void main(String[] args)
  {
    ArrayList<Person> al1 = new ArrayList<Person>();
    al1.add(new Person("李娟娟"));
    al1.add(new Person("孙小双"));
    al1.add(new Person("华天晓"));
    print(al1);

    ArrayList<Student> al2 = new ArrayList<Student>();
    al2.add(new Student("李娟娟"));
    al2.add(new Student("孙小双"));
    al2.add(new Student("华天晓"));
    print(al2);
  }
  public static void print(ArrayList<? extends Person> al)
  {
    Iterator<? extends Person> it = al.iterator();
    while(it.hasNext())
    {
      System.out.println("print：" + it.next().getName());
    }
  }
}
class Person
{
  private String name;
  Person(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return this.name;
  }
}
class Student extends Person
{
  Student(String name)
  {
    super(name);
  }
}
