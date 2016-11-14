package pack17;
import java.io.*;
import java.net.*;
class NetDemo13{
    public static void main(String[] args) throws Exception {
        // 练习客户端发送字符，服务端接收，并转化为大写后返回给客户端
        // 客户端
        Socket s = new Socket("localhost", 6007);
        PrintWriter ps = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

        String consoleReader = null;
        while((consoleReader = br1.readLine()) != null){
            if(consoleReader == "over")break;
            ps.println(consoleReader);
            System.out.println("服务端回发的信息：" + br.readLine());
        }
        s.close();
        br1.close();
    }
}
