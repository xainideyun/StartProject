package pack11;
import java.util.*;
class CollectionDemo6
{
  public static void main(String[] args)
  {
    ArrayList<String> al = new ArrayList<String>();
    al.add("����");
    al.add("����Ȼ");
    al.add("��С˫");
    al.add("������");
    ArrayList<Integer> al1 = new ArrayList<Integer>();
    al1.add(12);
    al1.add(2);
    al1.add(4);
    al1.add(6);
    show(al);
    show(al1);
  }
  public static void show(ArrayList<?> al)
  {
    Iterator it = al.iterator();
    while(it.hasNext())
    {
      System.out.println("show:"+it.next());
    }
  }
}
