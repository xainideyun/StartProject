class DemoCls1
{
  public int calc(int a,int b) throws Exception
  {
    return a/b;
  }
}

class ExceptionDemo2
{
  public static void main(String[] args) throws Exception
  {
    DemoCls1 c = new DemoCls1();
    System.out.println(c.calc(5,0));


  }
}
