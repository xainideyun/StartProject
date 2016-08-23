class DemoCls4
{
  void method()
  {
    try
    {
      throw new RuntimeException("出错了！");
    }
    // catch(Exception e)
    // {
    //   e.printStackTrace();
    // }
    finally
    {
      System.out.println("释放资源...");
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
