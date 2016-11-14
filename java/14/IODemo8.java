package pack13;
import java.io.*;
class IODemo8{
  public static void main(String[] args) {
    BufferedReader br = null;
    BufferedWriter bw = null;
    try{
      br = new BufferedReader(new FileReader("IODemo7.java"));
      bw = new BufferedWriter(new FileWriter("..\\test\\IODemo7_Copy.java", true));
      String str = null;
      while((str = br.readLine()) != null){
        bw.write(str);
        bw.newLine();
      }
    }
    catch(Exception e){
      throw new RuntimeException("文件流异常");
    }
    finally{
      if(br != null){
        try{
          br.close();
        }
        catch (Exception e) {
          throw new RuntimeException("关闭读取流异常");
        }
      }
      if(bw != null){
        try{
          bw.close();
        }
        catch (Exception e) {
          throw new RuntimeException("关闭写入流异常");
        }
      }
    }
  }
}
