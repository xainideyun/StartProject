
class MyException extends Exception
{
  public MyException(String name)
  {
    super(name);
  }
}

class DemoCls2
{
  public int calc(int a,int b) throws MyException
  {
    if(b == 0)
    {
      throw new MyException("Äã³ýÒÔ0ÁË...");
    }
    return a/b;
  }
}

class ExceptionDemo3
{
  public static void main(String[] args)
  {
    DemoCls2 c = new DemoCls2();
    try
    {
      int result = c.calc(5,0);
      System.out.println(result);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
