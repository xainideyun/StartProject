/*
  synchronized
    Í¬²½´úÂë¿é
*/
package pack6;
class ThreadCls4 implements Runnable
{
  private int tick = 100;
  private Object obj = new Object();
  public void run()
  {
    while(true)
    {
      synchronized(obj)
      {
        if(tick > 0)
        {
          try{Thread.currentThread().sleep(10);}catch(Exception e){}
          System.out.println(Thread.currentThread().getName() + "£º" + tick--);
        }
        else
        {
          break;
        }
      }
    }
  }
}
class ThreadDemo4
{
  public static void main(String[] args)
  {
    ThreadCls4 c = new ThreadCls4();
    new Thread(c).start();
    new Thread(c).start();
    new Thread(c).start();
    new Thread(c).start();
  }
}
