package pack8;
import java.util.concurrent.locks.*;
/*
  �ö�����ʵ����ֻ���ѶԷ��Ĳ���
*/

class ProducerConsumerDemo2
{
  public static void main(String[] args)
  {
    Resource r = new Resource();
    new Thread(new Producer(r)).start();
    new Thread(new Producer(r)).start();
    new Thread(new Consumer(r)).start();
    new Thread(new Consumer(r)).start();
  }
}
class Resource
{
  private String name;
  private int num;
  private boolean flag = false;
  Lock lock = new ReentrantLock();
  Condition condition_pro = lock.newCondition();
  Condition condition_con = lock.newCondition();
  public void create(String name) throws Exception
  {
    try
    {
      lock.lock();
      while(flag)
        condition_pro.await();
      this.name = name + "......" + num++;
      System.out.println(Thread.currentThread().getName() + "......������-----" + this.name);
      flag = true;
      condition_con.signal();
    }
    finally
    {
      lock.unlock();
    }
  }
  public void sell() throws Exception
  {
    try
    {
      lock.lock();
      while(!flag)
        condition_con.await();
      System.out.println(Thread.currentThread().getName() + "----------------------------������-------" + this.name);
      flag = false;
      condition_pro.signal();
    }
    finally
    {
      lock.unlock();
    }
  }
}
class Producer implements Runnable
{
  private Resource r;
  Producer(Resource r)
  {
    this.r = r;
  }
  public void run()
  {
    while(true)
    {
      try
      {
        r.create(".NET���׽̳�");
      }
      catch(Exception e)
      {

      }
    }
  }
}
class Consumer implements Runnable
{
  private Resource r;
  Consumer(Resource r)
  {
    this.r = r;
  }
  public void run()
  {
    while(true)
    {
      try
      {
        r.sell();
      }
      catch(Exception e)
      {

      }
    }
  }
}
