
/**
  这是一个对int[]操作的工具类，里面提供了两数的加法、数组的排序以及打印功能
  @author 孙小双
  @version v1.1
*/
public class MyTool
{
  static
  {
    System.out.println("静态代码块...");
  }
  public static int add(int a,int b)
  {
    return a + b;
  }
  {
    System.out.println("1");
  }
  {
    System.out.println("2");
  }

  /**
    选择排序
    @param arr 接收一个int[]类型的数组
    @return 会返回一个从小到大的排序
  */
  public static void selectSort(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; i++)
    {
      for (int j = i; j < arr.length - 1; j++)
      {
        if (arr[i] > arr[j + 1])
        {
          swap(arr,i,j+1);
        }
      }
    }
  }
  public static void bubbleSort(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; i++)
    {
      for (int j = 0; j < arr.length - i - 1; j++)
      {
        if (arr[j] > arr[j + 1])
        {
          swap(arr,j,j+1);
        }
      }
    }
  }
  public static void showArr(int[] arr)
  {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++)
    {
      if(i == arr.length - 1)
        System.out.println(arr[i] + "]");
      else
        System.out.print(arr[i] + ",");
    }
  }
  private static void swap(int[] arr,int n1,int n2)
  {
    arr[n1] = arr[n1] ^ arr[n2];
    arr[n2] = arr[n1] ^ arr[n2];
    arr[n1] = arr[n1] ^ arr[n2];
  }
}
