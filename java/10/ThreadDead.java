package pack7;
class DeadCls implements Runnable
{
  boolean flag;
  public DeadCls(boolean b)
  {
    flag = b;
  }
  public void run()
  {
    if(flag)
    {
      synchronized(MyLock.locka)
      {
        System.out.println("if locka...");
        synchronized(MyLock.lockb)
        {
          System.out.println("if lockb...");
        }
      }
    }
    else
    {
      synchronized(MyLock.lockb)
      {
        System.out.println("else lockb...");
        synchronized(MyLock.locka)
        {
          System.out.println("else locka...");
        }
      }
    }
  }
}

class MyLock
{
  public static MyLock locka = new MyLock();
  public static MyLock lockb = new MyLock();
}

class ThreadDead
{
  public static void main(String[] args)
  {
    Thread t1 = new Thread(new DeadCls(true));
    Thread t2 = new Thread(new DeadCls(false));
    t1.start();
    // try{Thread.sleep(20);}catch(Exception e){}
    t2.start();
  }
}
