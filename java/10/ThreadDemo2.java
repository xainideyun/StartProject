class ThreadDemo2
{
  public static void main(String[] args)
  {
    Thread t = new Thread()
    {
      public void run()
      {
        for (int i=0; i<60; i++)
        {
          System.out.println("i="+i);
        }
      }
    };
    t.start();
  }
}
