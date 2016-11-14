package pack8;
class producerConsumerDemo
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
  private int count = 1;
  private boolean flag = false;
  public synchronized void create(String name)
  {
    while(flag)
      try{this.wait();}catch(Exception e){}
    this.name = name + "---" + count++;
    System.out.println(Thread.currentThread().getName() + "...������" + this.name);
    flag = true;
    this.notifyAll();
  }
  public synchronized void sell()
  {
    while(!flag)
      try{this.wait();}catch(Exception e){}
    System.out.println(Thread.currentThread().getName() + "...�����ߡ�����������" + this.name);
    flag = false;
    this.notifyAll();
  }
}
class Producer implements Runnable
{
  private Resource r;
  public Producer(Resource r)
  {
    this.r = r;
  }
  public void run()
  {
    while(true)
    {
      r.create("ƻ���ֻ�");
    }
  }
}
class Consumer implements Runnable
{
  private Resource r;
  public Consumer(Resource r)
  {
    this.r = r;
  }
  public void run()
  {
    while(true)
    {
      r.sell();
    }
  }
}
