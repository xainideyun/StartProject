package pack11;
import java.util.*;
class CollectionDemo8
{
  public static void main(String[] args)
  {
    // Hashtable m = new Hashtable();
    // m.put("�","����");
    Map<Integer,String> m = new HashMap<Integer,String>();
    m.put(2,"�뿪��");
    m.put(4,"��С˫");
    m.put(6,"��ȥ");
    // Collection<String> it = m.values();
    // Iterator o = it.iterator();
    // while(o.hasNext())
    // {
    //   System.out.println("show---" + o.next());
    // }

    Set<Integer> sArr = m.keySet();
    Iterator<Integer> t = sArr.iterator();
    while(t.hasNext())
    {
      Integer key = t.next();
      System.out.println("key:" + key + ",value:" + m.get(key));
    }
  }
}
