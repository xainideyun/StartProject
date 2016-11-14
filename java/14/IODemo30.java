package pack13;
import java.util.*;
import java.io.*;
class IODemo30{
    public static void main(String[] args) throws IOException {
        // 将上一节切割的文件合并为原始文件
        Vector v = new Vector();
        v.add(new FileInputStream("f:\\copy\\1.avi"));
        v.add(new FileInputStream("f:\\copy\\2.avi"));
        v.add(new FileInputStream("f:\\copy\\3.avi"));
        v.add(new FileInputStream("f:\\copy\\4.avi"));
        v.add(new FileInputStream("f:\\copy\\5.avi"));
        v.add(new FileInputStream("f:\\copy\\6.avi"));
        v.add(new FileInputStream("f:\\copy\\7.avi"));
        v.add(new FileInputStream("f:\\copy\\8.avi"));
        v.add(new FileInputStream("f:\\copy\\9.avi"));
        SequenceInputStream sis = new SequenceInputStream(v.elements());
        FileOutputStream fos = new FileOutputStream("f:\\copy\\old.avi");
        int len = 0;
        byte[] buffer = new byte[1024];
        while((len = sis.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        sis.close();
        fos.close();
    }
}
