package pack11;
import java.util.*;
class CollectionDemo5
{
  public static void main(String[] args)
  {
    Tool<Integer> t = new Tool<Integer>();
    t.show(2);

    Tool1.show("你好");

  }
}
class Tool<T>                                       // 泛型类
{
  public void show(T t)
  {
    System.out.println("show:"+t);
  }
}
class Tool1
{
  public static <T> void show(T t)        // 泛型方法
  {
    System.out.println("show：" + t);
  }
}
