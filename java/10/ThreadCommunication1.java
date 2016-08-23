/*
  �̼߳�ͨѶ����ʵ���Ƕ���̲߳���ͬһ����Դ�����ǲ����ķ�����ͬ
*/
package pack8;
class Person
{
  String name;
  int age;
  boolean flag = false;
}

class Input implements Runnable
{
  private Person p;
  Input(Person p)
  {
    this.p = p;
  }
  public void run()
  {
    int x = 0;
    while(true)
    {
      synchronized(p)
      {
        if(!p.flag)
          try{p.wait();}catch(Exception e){}
        if(x == 0)
        {
          p.name = "����Ȼ";
          p.age = 27;
        }
        else
        {
          p.name = "��С˫";
          p.age = 30;
        }
        x = (x+1)%2;
        p.flag = true;
        p.notify();
      }
    }
  }
}
class Output implements Runnable
{
  private Person p;
  Output(Person p)
  {
    this.p = p;
  }
  public void run()
  {
    while(true)
    {
      synchronized(p)
      {
        if(p.flag)
          try{p.wait();}catch(Exception e){}
        System.out.println(p.name + "___" + p.age);
        p.flag = false;
        p.notify();
      }
    }
  }
}

class ThreadCommunication1
{
  public static void main(String[] args)
  {
    Person p = new Person();
    Input input = new Input(p);
    Output output = new Output(p);
    new Thread(input).start();
    new Thread(output).start();
  }
}
