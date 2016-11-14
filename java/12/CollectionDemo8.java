package pack11;
import java.util.*;
class CollectionDemo8
{
  public static void main(String[] args)
  {
    // Hashtable m = new Hashtable();
    // m.put("李凯","李娟娟");
    Map<Integer,String> m = new HashMap<Integer,String>();
    m.put(2,"离开我");
    m.put(4,"孙小双");
    m.put(6,"咯去");
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
