package pack10;
import java.util.*;
class CollectionDemo1
{
  public static void main(String[] args)
  {
    ArrayList list1 = new ArrayList();
    list1.add("sunxsh1");
    list1.add("sunxsh2");
    list1.add("sunxsh3");
    list1.add("sunxsh4");
    list1.add("sunxsh5");
    ArrayList list2 = new ArrayList();
    list2.add("sunxsh4");
    list2.add("sunxsh1");
    list2.add("sunxsh8");
    list2.add("sunxsh9");
    list2.add("sunxsh10");


    // list1.retainAll(list2);          // È¥½»¼¯
    Iterator it = list1.iterator();
    while(it.hasNext())
      System.out.println(it.next());


    // System.out.println(list1);

  }
}
