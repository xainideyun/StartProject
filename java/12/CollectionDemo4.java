package pack11;
import java.util.*;
class CollectionDemo4
{
  public static void main(String[] args)
  {
    ArrayList<String> arr = new ArrayList<String>();
    arr.add("孙小双");
    arr.add("李怡然");
    arr.add("李娟娟");
    arr.add("华天晓花挑选");
    Iterator<String> it = arr.iterator();
    while(it.hasNext())
    {
      String str = it.next();
      System.out.println(str+"..."+str.length());
    }
  }
}
