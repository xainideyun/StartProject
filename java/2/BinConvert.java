class BinConvert
{
  public static void main(String[] args)
  {
    toBin(59);
  }
  public static void toBin(int num)
  {
    StringBuffer sb = new StringBuffer();
    while(num > 0)
    {
      sb.append(num%2);
      num = num>>1;
    }
    System.out.println(sb.reverse());
  }
}
