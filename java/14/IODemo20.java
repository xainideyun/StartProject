package pack13;
import java.io.*;
import java.util.*;
import java.text.*;
class IODemo20{
  public static void main(String[] args) throws IOException {
    File f1 = new File("abc.txt");
    File f2 = new File("f:"+File.separator+"a", "sunxsh.txt");
    File f3 = new File(new File("g:"+File.separator+"abc"), "lijuanjuan.md");
    System.out.println("f1:"+f1);
    System.out.println("f2:"+f2);
    System.out.println("f3:"+f3);

    System.out.println(f2.getParent());


  }
}
