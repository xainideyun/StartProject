package pack11;
import java.util.*;
class CollectionDemo9
{
  public static void main(String[] args)
  {
    char[] arr = args[0].toCharArray();
    TreeMap<Character, Integer> m = new TreeMap<Character, Integer>();
    for (int i = 0; i < arr.length; i ++)
    {
      if(m.containsKey(arr[i]))
      {
        int num = m.get(arr[i]);
        m.put(arr[i], num + 1);
        continue;
      }
      m.put(arr[i], 1);
    }

    Iterator<Map.Entry<Character, Integer>> it = m.entrySet().iterator();
    while(it.hasNext())
    {
      Map.Entry<Character, Integer> item = it.next();
      System.out.println(item.getKey() + ".." + item.getValue());
    }
  }
}
