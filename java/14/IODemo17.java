package pack13;
import java.io.*;
class IODemo17{
  public static void main(String[] args) throws IOException {
    // ��һ��ͼƬ�ļ��洢����һ���ļ���
    BufferedInputStream br = new BufferedInputStream(new FileInputStream("workflow.png"));
    BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("copy_17.png"));
    int ch = 0;
    while((ch = br.read()) > -1){
      bw.write(ch);
    }
    br.close();
    bw.close();
  }
}
