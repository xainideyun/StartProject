package pack11;
import java.util.*;
class CollectionDemo5
{
  public static void main(String[] args)
  {
    Tool<Integer> t = new Tool<Integer>();
    t.show(2);

    Tool1.show("���");

  }
}
class Tool<T>                                       // ������
{
  public void show(T t)
  {
    System.out.println("show:"+t);
  }
}
class Tool1
{
  public static <T> void show(T t)        // ���ͷ���
  {
    System.out.println("show��" + t);
  }
}
