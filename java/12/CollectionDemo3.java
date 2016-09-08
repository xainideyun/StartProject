package pack11;
import java.util.*;
class Student
{
  private String name;
  private int age;
  Student (String name, int age)
  {
    this.name = name;
    this.age = age;
  }
  public String getName()
  {
    return this.name;
  }
  public String toString()
  {
    return this.name + "," + this.age;
  }
}
class CompName implements Comparator<Student>
{
  public int compare(Student s1,Student s2)
  {
    return s1.getName().compareTo(s2.getName());
  }
}
class CollectionDemo3
{
  public static void main(String[] args)
  {
    // TreeSet ts = new TreeSet(new CompName());
    TreeSet ts = new TreeSet(new Comparator<Student>()
    {
      public int compare(Student s1, Student s2)
      {
        return s1.getName().compareTo(s2.getName());
      }
    });
    ts.add(new Student("huatianxiao",28));
    ts.add(new Student("liyiran",25));
    ts.add(new Student("lijuanjuan",26));
    ts.add(new Student("sunxsh",44));
    ts.add(new Student("lijj",23));
    Iterator it = ts.iterator();
    while(it.hasNext())
    {
      System.out.println(it.next());
    }
  }
}
