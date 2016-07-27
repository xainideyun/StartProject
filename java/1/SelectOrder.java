class Demo4
{
  public static void main(String[] args)
  {
    int[] arr = {3,4,6,755,32,325,654,2};
    minOrder(arr);
    printArr(arr);
  }
  public  static void minOrder(int[] arr)
  {
    for (int i = 0;i < arr.length;i++)
    {
      for (int j = i + 1; j < arr.length ; j++ )
      {
        if(arr[i]>arr[j])
        {
          arr[i] = arr[i] ^ arr[j];
          arr[j] = arr[i] ^ arr[j];
          arr[i] = arr[i] ^ arr[j];
        }
      }
    }
  }
  public static void printArr(int[] arr)
  {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++)
    {
      if(i != arr.length - 1)
        System.out.print(arr[i] + ",");
      else
        System.out.println(arr[i] + "]");
    }
  }
}
