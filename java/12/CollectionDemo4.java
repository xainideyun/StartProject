package pack11;
import java.util.*;
class CollectionDemo4
{
  public static void main(String[] args)
  {
    ArrayList<String> arr = new ArrayList<String>();
    arr.add("��С˫");
    arr.add("����Ȼ");
    arr.add("����");
    arr.add("����������ѡ");
    Iterator<String> it = arr.iterator();
    while(it.hasNext())
    {
      String str = it.next();
      System.out.println(str+"..."+str.length());
    }
  }
}
