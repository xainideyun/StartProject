package pack13;
import java.io.*;
class IODemo1
{
  public static void main(String[] args) throws IOException
  {
    FileWriter fw = new FileWriter("Demo.txt");
    fw.write("ËïÐ¡Ë«");
    fw.flush();
    fw.close();
  }
}
