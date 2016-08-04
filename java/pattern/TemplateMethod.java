/**
  模版方法模式：在定义功能时，功能的一部分是确定的，但是有一部分是不确定的，而确定的部分在使用不确定的部分，那么这时就将不确定的部分暴露出去，由继承他的子类去完成
  @autor 孙小双
  @version 1.0.1
*/
public abstract class GetTime
{
  public final void getTime()
  {
    long start = System.currentTimeMillis();
    runcode();
    long end = System.currentTimeMillis();
    System.out.println("毫秒数：" + (end - start));
  }
  public abstract void runcode();
}

class SubTime extends GetTime
{
  public void runcode()
  {
    for (int i = 0; i < 1000; i++)
    {
      System.out.print(i);
    }
  }
}

class TemplateMethod
{
  public static void main(String[] args)
  {
    GetTime gt = new SubTime();
    gt.getTime();
  }
}
