class StaticDemo2
{
  public static void main(String[] args)
  {
    System.out.println(MyTool.add(4,5));
    int[] arr = {4,5,6,433,2,345,2,1,2};
    MyTool.showArr(arr);
    MyTool.selectSort(arr);
    MyTool.showArr(arr);
    int[] arr1 = {3,1,33,45,12,32,2};
    MyTool.showArr(arr1);
    MyTool.bubbleSort(arr1);
    MyTool.showArr(arr1);
    MyTool mt = new MyTool();
  }
}
