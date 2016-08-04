/**
  ģ�淽��ģʽ���ڶ��幦��ʱ�����ܵ�һ������ȷ���ģ�������һ�����ǲ�ȷ���ģ���ȷ���Ĳ�����ʹ�ò�ȷ���Ĳ��֣���ô��ʱ�ͽ���ȷ���Ĳ��ֱ�¶��ȥ���ɼ̳���������ȥ���
  @autor ��С˫
  @version 1.0.1
*/
public abstract class GetTime
{
  public final void getTime()
  {
    long start = System.currentTimeMillis();
    runcode();
    long end = System.currentTimeMillis();
    System.out.println("��������" + (end - start));
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
