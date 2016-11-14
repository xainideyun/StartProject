class MyException extends RuntimeException
{
  public MyException(String msg)
  {
    super(msg);
  }
}

class DemoCls3
{
  public int calc(int a,int b)
  {
    if(b < 0)
    {
      throw new MyException("��������Ϊ����...");
    }
    return a/b;
  }
}

class ExceptionDemo4
{
  public static void main(String[] args)
  {
    DemoCls3 dc = new DemoCls3();
    int result = dc.calc(6,-2);
    System.out.println("��ӡ�Ľ���ǣ�" + result);
  }
}
