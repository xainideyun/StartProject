package pack13;
import java.io.*;
class IODemo12{
  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    copy();
    long end = System.currentTimeMillis();
    System.out.println(end - start + "∫¡√Î");
  }
  public static void copy() throws IOException
  {
    MyBufferedInputStream bis = new MyBufferedInputStream(new FileInputStream("video.avi"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("..\\test\\video_copy2.avi"));
    int key = 0;
    while((key = bis.myRead()) != -1){
      bos.write(key);
    }
    bis.myClose();
    bos.close();
  }
}
