package pack13;
import java.io.*;
class IODemo16{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("IODemo14.java")));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(true){
      String str = br.readLine();
      if(str == null)break;
      if("over".equals(str))break;
      bw.write(str.toUpperCase());
      bw.newLine();
      bw.flush();
    }
  }
}
