package pack13;
import java.io.*;
import java.util.*;
class IODemo28{
    public static void main(String[] args) throws IOException {
        // 合并流SequenceInputStream的使用
        Vector<FileInputStream> v = new Vector<FileInputStream>();
        v.add(new FileInputStream("1.txt"));
        v.add(new FileInputStream("2.txt"));
        v.add(new FileInputStream("3.txt"));
        SequenceInputStream sis = new SequenceInputStream(v.elements());
        FileOutputStream fw = new FileOutputStream("4.txt");
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = sis.read(buffer)) != -1){
            fw.write(buffer, 0, len);
        }
        sis.close();
        fw.close();
    }
}
