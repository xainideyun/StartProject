class Demo3
{
  public static void main(String[] args)
  {
      int n = 60;
      System.out.println(n.toString() + "的16进制输出为：");
      String str = "";
      for (int i = 0; i < 4; i++) {
        String k = n & 15;
        k+=str;
        str = k;
      }
      System.out.println(str);
  }
}
