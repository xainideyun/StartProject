package pack13;
import java.io.*;
class IODemo9{
  public static void main(String[] args) throws IOException {
    BufferedReadDemo brd = new BufferedReadDemo(new FileReader("Demo4.txt"));
    String line = brd.readLine();
    System.out.println(line);
    brd.close();
  }
}
class BufferedReadDemo{
  private Reader stream;
  public BufferedReadDemo(Reader stream){
    this.stream = stream;
  }
  public String readLine() throws IOException{
    int key = 0;
    String keyChar = null;
    StringBuilder sb = new StringBuilder();
    while((key = stream.read()) != -1){
      if(key == '\r')
        continue;
      if(key == '\n')
        break;
      sb.append((char)key);
    }
    return sb.toString();
  }
  public void close() throws IOException
  {
    stream.close();
  }
}
