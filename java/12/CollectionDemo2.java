package pack11;
import java.util.*;
class Student implements Comparable<Student>
{
  private String name;
  private int age;
  Student (String name, int age)
  {
    this.name = name;
    this.age = age;
  }
  public int compareTo(Student o)
  {
    if(this.age > o.age)
    {
      return 1;
    }
    else if(this.age == o.age)
    {
      return this.name.compareTo(o.name);
    }
    else
    {
      return -1;
    }
  }
  public String toString()
  {
    return this.name + "," + this.age;
  }
}
class CollectionDemo2
{
  public static void main(String[] args)
  {
    TreeSet ts = new TreeSet();
    ts.add(new Student("ËïĞ¡Ë«",29));
    ts.add(new Student("sunxsh",26));
    ts.add(new Student("ÒüÏş³©",21));
    ts.add(new Student("Àî¾ê¾ê",22));
    ts.add(new Student("ÀîâùÈ»",27));
    ts.add(new Student("lijj",26));
    Iterator it = ts.iterator();
    while(it.hasNext())
    {
      System.out.println(it.next());
    }
  }
}
