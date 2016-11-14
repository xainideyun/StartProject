/*
  买票程序
  多个窗口买票
*/

class Ticket implements Runnable//extends Thread
{
  private int num = 100;
  public void run()
  {
    while(true)
    {
      if(num > 0)
      {
        System.out.println(Thread.currentThread().getName() + ",sale--" + num--);
      }
    }
  }
}
class ThreadDemo3
{
  public static void main(String[] args)
  {
    // Ticket t1 = new Ticket();
    // Ticket t2 = new Ticket();
    // Ticket t3 = new Ticket();
    // Ticket t4 = new Ticket();
    //
    // t1.start();
    // t2.start();
    // t3.start();
    // t4.start();

      Runnable r = new Ticket();
      new Thread(r).start();
      new Thread(r).start();
      new Thread(r).start();
      new Thread(r).start();
  }
}
