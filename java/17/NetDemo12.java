package pack17;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
class NetDemo12{
    public static void main(String[] args) {
        // 网络传输文件练习（接收端）

        new FrameServer(6006);
    }
}
class FrameServer{
    private ServerSocket ss;

    FrameServer(int port){
        try{
            ss = new ServerSocket(port);
            init();
        }
        catch(Exception e){

        }
    }
    private void init() throws Exception {
        while(true){
            Socket s = ss.accept();
            new Thread(new Runnable(){
                public void run(){
                    try{
                        InputStream is = s.getInputStream();
                        byte[] buffer = new byte[1024 * 1024];
                        int len = 0;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
                        String fileName = sdf.format(new Date());
                        OutputStream os = new FileOutputStream(fileName);
                        while((len = is.read(buffer)) > -1){
                            os.write(buffer, 0, len);
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
