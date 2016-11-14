package pack17;
import java.io.*;
import java.net.*;
class NetDemo22{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6012);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        System.out.println(new String(buffer, 0, len));
        OutputStream os = s.getOutputStream();
        os.write("ÄãºÃÂð".getBytes());
        s.close();
        ss.close();
    }
}
