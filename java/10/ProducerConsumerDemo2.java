package pack8;
import java.util.concurrent.locks.*;
/*
  该对象中实现了只唤醒对方的操作
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
      System.out.println(Thread.currentThread().getName() + "......生产者-----" + this.name);
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
      System.out.println(Thread.currentThread().getName() + "----------------------------消费者-------" + this.name);
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
        r.create(".NET进阶教程");
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
