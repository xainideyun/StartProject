package pack17;
import java.io.*;
import java.net.*;
class NetDemo21{
    public static void main(String[] args) throws Exception {
        // 提供服务，供浏览器访问
        ServerSocket ss = new ServerSocket(6011);
        while(true){
            Socket s = ss.accept();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            pw.println("浏览器你好...");
            s.close();
        }
    }
}
