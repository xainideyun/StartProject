package pack13;
import java.io.*;
class IODemo2
{
  public static void main(String[] args)
  {
    // FileWriter fw = new FileWriter("path", true);  // ����һ��true��������ʾ�����������ļ�
    FileWriter fw = null;
    try
    {
      fw = new FileWriter("demo2.txt", true);
      fw.write("sunxiaoshuang");
    }
    catch(IOException e)
    {
      System.out.println("�����쳣��" + e.toString());
    }
    finally
    {
      try
      {
        if(fw != null)
          fw.close();
      }
      catch(IOException e)
      {

      }
    }
  }
}
