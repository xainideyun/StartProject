package pack13;
import java.io.*;
class MyBufferedInputStream{
  private FileInputStream in;
  MyBufferedInputStream(FileInputStream in){
    this.in = in;
  }
  private int count;
  private int pos;
  private byte[] buffer = new byte[1024];
  public int myRead() throws IOException {
    if(count == 0){
      count = in.read(buffer);
      if(count == 0)
        return -1;
      pos = 0;
      count--;
      return buffer[pos++] & 255;
    }
    else if(count > 0){
      count--;
      return buffer[pos++] & 255;
    }
    return -1;
  }
  public void myClose() throws IOException{
    in.close();
  }
}
