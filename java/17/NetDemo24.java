package pack17;
import java.io.*;
import java.net.*;
class NetDemo24{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();
        byte[] buffer = new byte[1024 * 1024];
        int len = is.read(buffer);
        System.out.println(new String(buffer, 0, len));
    }
}
