package pack13;
import java.io.*;
class IODemo21{
  public static void main(String[] args) throws IOException {
    // 过滤文件名称
    File f = new File("g:\\test");
    File[] fs = f.listFiles(new FilenameFilter(){
      public boolean accept(File dir, String name){
        return name.endsWith("txt");
      }
    });
    for(File file : fs){
      System.out.println(file);
    }
  }
}
