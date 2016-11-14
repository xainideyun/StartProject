package pack17;
import java.io.*;
import java.net.*;
class NetDemo10{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6005);
        while(true){
            Socket s = ss.accept();
            new Thread(new Runnable(){
                public void run(){
                    try{
                        InputStream is = s.getInputStream();
                        OutputStream os = s.getOutputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        String str = null;
                        while(true){
                            while((len = is.read(buffer)) > -1){
                                str = new String(buffer, 0, len);
                                System.out.println(str);
                                os.write(str.toUpperCase().getBytes());
                            }
                        }
                    }
                    catch(Exception e){
                        System.out.println("·þÎñ¶Ë³ö´í...");
                    }
                }
            }).start();
        }
    }
}
