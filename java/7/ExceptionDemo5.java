class DemoCls4
{
  void method()
  {
    try
    {
      throw new RuntimeException("�����ˣ�");
    }
    // catch(Exception e)
    // {
    //   e.printStackTrace();
    // }
    finally
    {
      System.out.println("�ͷ���Դ...");
    }
  }
}

class ExceptionDemo5
{
  public static void main(String[] args)
  {
    DemoCls4 c = new DemoCls4();
    c.method();
  }
}
