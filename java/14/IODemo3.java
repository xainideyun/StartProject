package pack13;
import java.io.*;
class IODemo3
{
  public static void main(String[] args)  throws IOException
  {
    FileReader fr = new FileReader("Demo.txt");
    int key = 0;
    StringBuilder sb = new StringBuilder();
    while(true)
    {
      key = fr.read();
      if(key == -1) break;
      sb.append((char)key);
    }
    System.out.println(sb);
  }
}
