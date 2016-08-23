/*
  饿汉式单例模式
class Single
{
  private static final Single s = new Single();
  private Single(){}
  public static Single getInstance()
  {
    return s;
  }
}
*/

/*
  懒汉式单例模式
*/
class Single
{
  private static Single s;
  private Single(){}
  public static Single getInstance()
  {

    if(s == null)
    {
      synchronized(Single.class)
      {
        if(s == null)
          s = new Single();
      }
    }
    return s;
  }
}
