class HexConvert
{
  public static void main(String[] args)
  {
    toHex(60);
    // System.out.println(2+'A');
  }
  public static void toHex(int num)
  {
    StringBuffer sb = new StringBuffer();
    while(num > 0)
    {
      int temp = num & 15;
      if (temp > 9)
      {
        sb.append((char)(temp - 10 + 'a'));
      }
      else
      {
        sb.append(temp);
      }
      num = num >>> 4;
    }
    System.out.println("0x" + sb.reverse());
  }
}
