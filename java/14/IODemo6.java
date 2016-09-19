package pack13;
import java.io.*;
class IODemo6
{
  public static void main(String[] args) throws IOException
  {
    // 创建一个字符写入流对象
    FileWriter fw = new FileWriter("Demo4.txt");
    // 为了提高字符写入流效率，加入了缓冲技术
    // 只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("孙小双");
    bw.newLine();           // 换行
    bw.close();
  }
}
