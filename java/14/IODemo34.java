package pack13;
import java.io.*;
class IODemo34{
    public static void main(String[] args) throws IOException{
        // RandomAccessFile��ʹ��
        // write();
        read();
    }
    public static void read() throws IOException{
        RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
        raf.seek(10);           // ����ָ���λ��
        byte[] buffer = new byte[6];
        raf.read(buffer);
        System.out.println("name=" + new String(buffer));
        byte[] buffer2 = new byte[4];
        int age = raf.readInt();
        System.out.println("age=" + age);
    }
    public static void write() throws IOException{
        RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
        raf.write("��С˫".getBytes());
        raf.writeInt(99);
        raf.write("����".getBytes());
        raf.writeInt(78);
        raf.close();
    }
}
