package pack13;
import java.io.*;
class IODemo11{
  public static void main(String[] args) throws IOException {
    // copy_1();
    copy_2();
  }

  public static void copy_1() throws IOException {
    FileInputStream fis = new FileInputStream("workflow.png");
    FileOutputStream fos = new FileOutputStream("..\\test\\workflow_copy.png");
    int move = 0;
    byte[] buffer = new byte[1024];
    while((move = fis.read(buffer)) != -1){
      fos.write(buffer, 0, move);
    }
    fis.close();
    fos.close();
  }

  public static void copy_2() throws IOException {
    FileInputStream fis = new FileInputStream("workflow.png");
    FileOutputStream fos = new FileOutputStream("..\\test\\workflow_copy_2.png");
    byte[] buffer = new byte[fis.available()];
    fis.read(buffer);
    fos.write(buffer);
    fis.close();
    fos.close();
  }

}
