package pack13;
import java.io.*;
class IODemo18{
  public static void main(String[] args) throws IOException {
    // ��һ���ı����ݴ�ӡ�ڿ���̨��
    BufferedReader br = new BufferedReader(new FileReader("IODemo7.java"));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = "";
    while((str = br.readLine()) != null){
      bw.write(str);
      bw.newLine();
    }
    br.close();
    bw.close();
  }
}
