package pack13;
import java.io.*;
class IODemo5
{
  public static void main(String[] args) throws IOException
  {
    FileReader fr = new FileReader("IODemo5.java");
    int key = 0;
    char[] buffer = new char[32];
    FileWriter fw = new FileWriter("..\\test\\IODemo5_Copy.java");
    while((key = fr.read(buffer)) != -1)
    {
      fw.write(new String(buffer, 0 ,key));
    }
    fr.close();
    fw.close();
  }
}
