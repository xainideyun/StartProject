class OptimizationConvert
{
  public static void main(String[] args)
  {
    // toBin(6);
    // toBa(60);
    toHex(129);
  }
  private static void toBin(int num)
  {
    trans(num,1,1);
  }
  private static void toBa(int num)
  {
    trans(num,7,3);
  }
  private static void toHex(int num)
  {
    trans(num,15,4);
  }
  private static void trans(int num,int base,int offset)
  {
    if(num == 0)
    {
      System.out.println(0);
      return;
    }
    char[] charArr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    char[] arr = new char[32];
    int pos = arr.length;
    while(num > 0)
    {
      int temp = num & base;
      arr[--pos] = charArr[temp];
      num = num >>> offset;
    }
    for (int i=pos; i<arr.length; i++)
    {
      System.out.print(arr[i]);
    }
  }
}
