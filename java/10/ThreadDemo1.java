package pack5;
class ThreadCls1 extends Thread
{
  public void run()
  {
    for (int i = 0; i < 60; i++)
      System.out.println("我是线程方法...");
  }
}

class ThreadDemo1
{
  public static void main(String[] args)
  {
    ThreadCls1 t = new ThreadCls1();
    t.start();
    for (int i = 0; i < 60; i++)
      System.out.println("我是主方法...");
  }
}
