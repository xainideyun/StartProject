
package pack12;
import java.util.*;
class SystemDemo
{
  public static void main(String[] args)
  {
    Map m =System.getProperties();
    // Iterator it = m.keySet().iterator();
    // while(it.hasNext())
    // {
    //   Object key = it.next();
    //   System.out.println("key:" + key + ",value:" + m.get(key));
    // }

    // for(Object obj : m.keySet())
    // {
    //   System.out.println(obj + "£º" + m.get(obj));
    // }

    // Set<String> s = System.getProperties().stringPropertyNames();
    // for(String str : s)
    // {
    //   System.out.println(str);
    // }

    String value = System.getProperty("myProperty");
    System.out.println(value);
  }
}
