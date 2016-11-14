package pack13;
import java.io.*;
class IODemo19{
  public static void main(String[] args) throws IOException {
    try{
      String str = null;
      String str1 = str.toString();
    }
    catch(Exception e){
      e.printStackTrace(new PrintStream("Exception.txt"));
    }
    System.getProperties().list(System.out);
  }
}
