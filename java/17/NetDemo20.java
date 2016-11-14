package pack17;
import java.io.*;
import java.net.*;
class NetDemo20{
    public static void main(String[] args) throws Exception {
        // 模拟用户登录（服务端）
        ServerSocket ss = new ServerSocket(6010);
        BufferedReader list = new BufferedReader(new FileReader("Files\\UserList.txt"));
        while(true){
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + ":connection......");
            new Thread(new Runnable(){
                public void run(){
                    try{
                        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                        Boolean flag = false;
                        for (int i = 0; i < 3; i++) {
                            String name = br.readLine();
                            System.out.println(name.length());
                            if(name == null) break;
                            String line;
                            while((line = list.readLine()) != null){
                                System.out.println(line.length());
                                if(line == name){
                                    flag = true;
                                    break;
                                }
                            }
                            System.out.println(flag);
                            if(flag){
                                pw.println("0");
                                System.out.println("用户：[" + name + "]登录成功");
                            }
                            else {
                                pw.println("1");
                            }
                        }
                    }
                    catch(Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}
