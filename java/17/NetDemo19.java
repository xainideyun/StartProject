package pack17;
import java.io.*;
import java.net.*;
class NetDemo19{
    public static void main(String[] args) throws Exception {
        // 模拟用户登录｛客户端｝
        Socket s = new Socket("localhost", 6010);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader brFeed = new BufferedReader(new InputStreamReader(s.getInputStream()));

        for (int i = 0; i < 3; i++) {
            String name = br.readLine();
            if(name == null)
                break;
            pw.println(name);
            String feed = brFeed.readLine();
            if(feed == "0"){
                System.out.println("登录成功...");
                break;
            }
            else {
                if(i == 2){
                    System.out.println("三次登录不成功，请十分钟后再登录...");
                }
                else {
                    System.out.println("登录失败，请重试...");
                }
            }
        }

        s.close();
    }
}
