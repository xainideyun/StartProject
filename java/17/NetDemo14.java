package pack17;
import java.io.*;
import java.net.*;
class NetDemo14{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6007);
        Socket s = ss.accept();
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String msg = null;
        while((msg = br.readLine()) != null){
            System.out.println("客户端发来的信息：" + msg);
            pw.println(msg.toUpperCase());
        }
    }
}
