class ExceptionDemo1
{
  public static void main(String[] args)
  {
    try
    {
      // int a = 6/0;
      throw new MyException("´íÎó...");
    }
    catch(MyException e)
    {
      System.out.println(e);
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}

class MyException extends Exception
{
  public MyException(String error)
  {
    super(error);
  }
}
