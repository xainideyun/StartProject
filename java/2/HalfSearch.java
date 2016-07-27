class HalfSearch
{
  public static void main(String[] args)
  {
    int[] arr = {3,4,5,7,8,9,10,33};
    System.out.println(getIndex(arr,55));
  }
  public static int getIndex(int[] arr,int key)
  {
    int mid = arr.length/2;
    int min = 0;
    int max = arr.length - 1;
    while(arr[mid] != key)
    {
      if(arr[mid] > key)
      {
        max = mid - 1;
      }
      else
      {
        min = mid + 1;
      }
      mid = (max + min + 1)/2;
      if(max < min)return -1;
    }
    return mid;
  }
}
