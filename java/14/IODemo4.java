package pack13;
import java.io.*;
class IODemo4
{
  public static void main(String[] args) throws IOException
  {
    FileReader fr = new FileReader("IODemo1.java");
    char[] buffer = new char[10];
    int num = 0;
    while((num = fr.read(buffer)) > -1)
    {
      System.out.print(new String(buffer, 0, num));
      // System.out.print(buffer);
    }
    fr.close();
  }
}
