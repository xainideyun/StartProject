package pack13;
import java.io.*;
class IODemo6
{
  public static void main(String[] args) throws IOException
  {
    // ����һ���ַ�д��������
    FileWriter fw = new FileWriter("Demo4.txt");
    // Ϊ������ַ�д����Ч�ʣ������˻��弼��
    // ֻҪ����Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯������
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("��С˫");
    bw.newLine();           // ����
    bw.close();
  }
}
