package pack8;
class Person
{
  private String name;
  private int age;
  private boolean flag = false;
  public synchronized void set(String name, int age)
  {
    if(flag)
      try{this.wait();}catch(Exception e){}
    this.name = name;
    this.age = age;
    flag = true;
    this.notify();
  }
  public synchronized void print()
  {
    if(!flag)
      try{this.wait();}catch(Exception e){}
    System.out.println(this.name + "____" + this.age);
    flag = false;
    this.notify();
  }
}

class Input implements Runnable
{
  private Person p;
  private int x;
  public Input(Person p)
  {
    this.p = p;
  }
  public void run()
  {
    while(true)
    {
      if(x == 0)
        p.set("ËïÐ¡Ë«",28);
      else
        p.set("Àî¾ê¾ê",27);
      x = (x + 1)%2;
    }
  }
}
class Output implements Runnable
{
  private Person p;
  public Output(Person p)
  {
    this.p = p;
  }
  public void run()
  {
    while(true)
    {
      p.print();
    }
  }
}
class ThreadCommunication2
{
  public static void main(String[] args)
  {
    Person p = new Person();
    new Thread(new Input(p)).start();
    new Thread(new Output(p)).start();
  }
}
