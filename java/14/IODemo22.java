package pack13;
import java.io.*;
import java.util.*;
class IODemo22{
  public static void main(String[] args) throws IOException {
    // ��ӡ��һ���ļ����µ������ļ��������ļ����µ��ļ�
    printDir(new File("G:\\BaiduYunDownload\\�鼮"), 0);

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
