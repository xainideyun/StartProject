class BubbleOrder
{
  public static void main(String[] args)
  {
    int[] arr = {5,6,44,21,3,66,13,6};
    printArr(arr);
    order(arr);
    printArr(arr);
  }
  public static void order(int[] arr)
  {
    for (int i=arr.length-1; i>0; i--)
    {
      for (int j=0; j<i; j++)
      {
        if(arr[j] > arr[j+1])
        {
          swap(arr,j,j+1);
        }
      }
    }
  }
  public static void swap(int[] arr ,int a,int b)
  {
    arr[a] = arr[a] ^ arr[b];
    arr[b] = arr[a] ^ arr[b];
    arr[a] = arr[a] ^ arr[b];
  }
  public static void printArr(int[] arr)
  {
    System.out.print("[");
    for (int i=0; i<arr.length; i++)
    {
      if(i == arr.length-1)
      {
        System.out.println(arr[i] + "]");
      }
      else
      {
        System.out.print(arr[i] + ",");
      }
    }
  }
}
