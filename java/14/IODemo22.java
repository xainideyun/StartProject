package pack13;
import java.io.*;
import java.util.*;
class IODemo22{
  public static void main(String[] args) throws IOException {
    // 打印出一个文件夹下的所有文件，包括文件夹下的文件
    printDir(new File("G:\\BaiduYunDownload\\书籍"), 0);

  }

  public static String strLayout(int layout){
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < layout; i++) {
          sb.append("|--");
      }
      return sb.toString();
  }

  public static void printDir(File dir, int layout) {
    File[] fs = dir.listFiles();
    String layoutTag = strLayout(layout);
    System.out.println(layoutTag + dir);
    for(File f : fs){
      if(f.isDirectory()){
        printDir(f, layout + 1);
        continue;
      }
      System.out.println(layoutTag + f);
    }
  }
}
