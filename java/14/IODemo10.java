package pack13;
import java.io.*;
class IODemo10{
  public static void main(String[] args) throws IOException {
    // write("Demo5.txt");
    read("Demo5.txt");
  }

  public static void read(String path) throws IOException
  {
    FileInputStream fis = new FileInputStream(path);
    StringBuilder sb = new StringBuilder();
    byte[] buffer = new byte[1024];
    int move = 0;
    while((move = fis.read(buffer)) != -1){
      sb.append(new String(buffer, 0, move));
    }
    fis.close();
    System.out.println(sb.toString());
  }

  public static void write(String path) throws IOException{
    FileOutputStream fos = new FileOutputStream(path);
    // byte[] buffer = {'2','r','d'};
    fos.write("bdnwjfke".getBytes());
    fos.close();
  }
}
