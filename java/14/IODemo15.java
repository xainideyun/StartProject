package pack13;
import java.io.*;
class IODemo15{
  public static void main(String[] args) throws IOException {
    InputStream in = System.in;
    int ch = 0;
    StringBuilder sb = new StringBuilder();
    while(true){
      ch = in.read();
      if(ch == '\r')
        continue;
      if(ch == '\n'){
        if("over".equals(sb.toString()))
          break;
          System.out.println(sb.toString().toUpperCase());
          sb.delete(0, sb.length());
      }
      else{
        sb.append((char)ch);
      }
    }
  }
}
