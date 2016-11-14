package pack13;
import java.io.*;
class IODemo7{
  public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("Demo4.txt");
    BufferedReader br = new BufferedReader(fr);
    // char[] buffer = new char[20];
    // int key = br.read(buffer);
    // System.out.println(new String(buffer, 0, key));
    // System.out.println(key);
    String str = null;
    while((str = br.readLine()) != null){
      System.out.println(str);
    }
    br.close();
  }
}
package pack13;
import java.io.*;
class IODemo7{
  public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("Demo4.txt");
    BufferedReader br = new BufferedReader(fr);
    // char[] buffer = new char[20];
    // int key = br.read(buffer);
    // System.out.println(new String(buffer, 0, key));
    // System.out.println(key);
    String str = null;
    while((str = br.readLine()) != null){
      System.out.println(str);
    }
    br.close();
  }
}
