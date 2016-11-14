package pack17;
import java.net.*;
import java.io.*;
class NetDemo7{
    public static void main(String[] args) throws Exception {
        // TCP发送端练习
        // 1. 创建Socket服务，并指定要连接的主机和端口
        Socket s = new Socket("127.0.0.1", 6004);
        // 2. 为了发送数据，获取Socket流中的输出流
        OutputStream os = s.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        InputStream is = s.getInputStream();
        new Thread(new Runnable(){
            public void run(){
                int lenIs = 0;
                while(true){
                    try{
                        lenIs = is.read(buffer);
                    }
                    catch(Exception e){

                    }
                    System.out.println(new String(buffer, 0, lenIs));
                }
            }
        }).start();
        while(true){
            Thread.sleep(1000);
            os.write(("你好吗" + len++).getBytes());
        }

    }
}
