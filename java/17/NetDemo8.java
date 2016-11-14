package pack17;
import java.io.*;
import java.net.*;
class NetDemo8{
    public static void main(String[] args) throws Exception {
        // TCP�������ϰ
        ServerSocket ss = new ServerSocket(6004);
        byte[] buffer = new byte[1024];

        while(true){
            Socket s = ss.accept();
            new Thread(new Runnable(){
                public void run(){
                    int record = 0;
                    try{
                        InputStream is = s.getInputStream();
                        OutputStream os = s.getOutputStream();
                        while(true){
                            if(!s.isConnected())break;
                            int len = is.read(buffer);
                            System.out.println(new String(buffer, 0, len));
                            os.write(("�յ���" + record++).getBytes());
                        }
                    }
                    catch(Exception e){
                        System.out.println("������..." + e);
                    }
                }

            }).start();
        }
    }
}
