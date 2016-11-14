package pack17;
import java.io.*;
import java.net.*;
class NetDemo17{
    public static void main(String[] args) throws Exception {
        // C:\Users\sunxsh\Desktop\ÂÖ²¥Í¼
        // ÉÏ´«Í¼Æ¬£¨¿Í»§¶Ë£©
        Socket s = new Socket("127.0.0.1", 6009);
        OutputStream os = s.getOutputStream();
        String filePath = "C:\\Users\\sunxsh\\Desktop\\ÂÖ²¥Í¼\\IMG_0080.JPG";
        InputStream is = new FileInputStream(filePath);
        // os.write("IMG_0080.JPG");
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = is.read(buffer)) > -1) {
            os.write(buffer, 0, len);
        }
        s.shutdownOutput();
        InputStream result =s.getInputStream();
        while((len = result.read(buffer)) > -1){
            System.out.println(new String(buffer, 0, len));
        }
        s.close();
        is.close();
    }
}
