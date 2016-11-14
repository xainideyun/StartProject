package pack13;
import java.io.*;
class IODemo29{
    public static void main(String[] args) throws IOException {
        // 将一个大文件切割为多个碎片文件
        FileInputStream fis = new FileInputStream("f:\\123.avi");
        File file = new File("f:\\copy");
        if(!file.exists()){
            file.mkdir();
        }
        // FileOutputStream fos = new FileOutputStream("f:\\111.avi");
        byte[] buffer = new byte[1024 * 1024];
        int len = 0;
        int num = 1;
        while((len = fis.read(buffer)) != -1){
            // fos.write(buffer, 0, len);
            FileOutputStream fos = new FileOutputStream("f:\\copy\\" + num + ".avi");
            fos.write(buffer, 0, len);
            fos.close();
            num++;
        }
        fis.close();
        // fos.close();
    }
}
