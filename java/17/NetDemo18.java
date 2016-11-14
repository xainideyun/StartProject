package pack17;
import java.io.*;
import java.net.*;
class NetDemo18{
    public static int count = 1;
    public static void main(String[] args) throws Exception {
        // C:\Users\sunxsh\Desktop\轮播图
        // 上传图片（服务端）
        ServerSocket ss = new ServerSocket(6009);
        while(true){
            Socket s = ss.accept();
            new Thread(new Runnable(){
                public void run(){
                    try{
                        OutputStream os = new FileOutputStream("Files\\" + count++ + ".jpg");
                        InputStream is = s.getInputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while((len = is.read(buffer)) > -1){
                            os.write(buffer, 0, len);
                        }
                        OutputStream result = s.getOutputStream();
                        result.write("上传成功...".getBytes());
                        os.close();
                        s.close();
                    }
                    catch(Exception e){
                        System.out.println("上传出错...");
                    }
                }
            }).start();
        }
    }
}
