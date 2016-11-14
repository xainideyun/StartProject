package pack13;
import java.io.*;
class IODemo14{
  public static void main(String[] args) throws IOException {
    InputStream in = System.in;
    int by = in.read();
    System.out.println(by);
  }
}
