package pack13;
import java.io.*;
 class IODemo27{
     public static void main(String[] args) throws IOException {
         // PrintWriter��ʹ��
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter bw = new PrintWriter(System.out, true);
         String line = null;
        //  System.out.autoFlush = true;
         while((line = br.readLine()) != null){
             bw.println(line.toUpperCase());
         }
         br.close();
         bw.close();
     }
 }
