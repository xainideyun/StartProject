package pack17;
import java.io.*;
import java.net.*;
class NetDemo16{
    private static int len = 1;
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6008);
        while(true){
            Socket s = ss.accept();
            System.out.println("连接客户端：" + s.getInetAddress());
            new Thread(new Runnable(){
                public void run(){
                    try{
                        byte[] buffer = new byte[1024 * 1024];
                        InputStream is = s.getInputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        System.out.println("读取文件...");
                        int count = is.read(buffer);
                        OutputStream os = new FileOutputStream("Files\\" + len++);
                        os.write(buffer, 0, count);
                        os.close();
                        System.out.println("返回数据...");
                        bw.write(len + "：发送完成...");
                        bw.newLine();
                        System.out.println("返回数据完成..........");
                        s.shutdownOutput();
                    }
                    catch(Exception e){
                        System.out.println("发生错误..." + e);
                    }
                }
            }).start();
        }
    }







}
