import java.util.*;
class InnerClsCollectionDemo
{
  public static void main(String[] args)
  {
    InnerClsCollection<String> list = new InnerClsCollection<String>();
    list.add("ËïĞ¡Ë«");
    list.add("Àî¾ê¾ê");
    list.add("ÀîâùÈ»");
    list.add("ÒüÏş³©");
    IteratorDemo it = list.iterator();
    while(it.hasNext())
      System.out.println(it.next());
  }
}

class InnerClsCollection<T>
{
  private ArrayList _list;
  public InnerClsCollection()
  {
    _list = new ArrayList();
  }
  public void add(Object element)
  {
    _list.add(element);
  }
  public void remove(Object element)
  {
    _list.remove(element);
  }
  public IteratorDemo iterator()
  {
    return new IteratorDemo()
    {
      private int num = 0;
      private int count = _list.size();
      public Object next()
      {
        if(!hasNext())
          return null;
        return _list.get(num++);
      }
      public boolean hasNext()
      {
        if(num < count)
          return true;
        return false;
      }
    };
  }
}
interface IteratorDemo
{
  Object next();
  boolean hasNext();
}
