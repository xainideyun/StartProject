
/**
  ����һ����int[]�����Ĺ����࣬�����ṩ�������ļӷ�������������Լ���ӡ����
  @author ��С˫
  @version v1.1
*/
public class MyTool
{
  static
  {
    System.out.println("��̬�����...");
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
    ѡ������
    @param arr ����һ��int[]���͵�����
    @return �᷵��һ����С���������
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
