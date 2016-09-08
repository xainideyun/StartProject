package pack11;
import java.util.*;
class CollectionDemo10
{
  public static void main(String[] args)
  {
    List<Student> list = new ArrayList<Student>();
    list.add(new Student("sunxsh",28));
    list.add(new Student("lijj",25));
    list.add(new Student("liyr",26));
    list.add(new Student("yinxch",65));
    list.add(new Student("liuyf",28));
    list.add(new Student("sunxiaoshuang",28));

    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    Collections.sort(list, new Comparator<Student>()
    {
      public int compare(Student s1, Student s2)
      {
        if (s1.getName().length() > s2.getName().length())
          return 1;
        else if(s1.getName().length() < s2.getName().length())
          return -1;
        else
        {
          return s1.getName().compareTo(s2.getName());
        }
      }
    });
    System.out.println(list);
  }
}

class Student implements Comparable<Student>
{
  private String name;
  private int age;
  public String getName()
  {
    return this.name;
  }
  public int getAge()
  {
    return this.age;
  }
  public Student(String name, int age)
  {
    this.name = name;
    this.age = age;
  }
  public String toString()
  {
    return this.name + "...." + this.age;
  }
  public int compareTo(Student s)
  {
    int num = new Integer(this.getAge()).compareTo(new Integer(s.getAge()));
    if(num == 0)
      return this.getName().compareTo(s.getName());
    return num;
  }
}
