package pack17;
import java.io.*;
import java.net.*;
class NetDemo21{
    public static void main(String[] args) throws Exception {
        // �ṩ���񣬹����������
        ServerSocket ss = new ServerSocket(6011);
        while(true){
            Socket s = ss.accept();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            pw.println("��������...");
            s.close();
        }
    }
}
