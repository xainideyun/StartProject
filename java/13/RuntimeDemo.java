package pack12;
import java.io.*;
class RuntimeDemo
{
  public static void main(String[] args) throws IOException
  {
    Runtime r = Runtime.getRuntime();
    r.exec(System.getProperty("myCommand"));
  }
}
