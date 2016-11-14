package pack13;
import java.io.*;
class IODemo35{
    public static void main(String[] args) throws IOException {
        // 基础数据类型的流对象DataStream
        // write();
        read();
    }
    public static void write() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("dis.txt"));
        dos.writeInt(289);
        dos.writeBoolean(false);
        dos.writeDouble(2903.422);
        dos.close();
    }
    public static void read() throws IOException{
        DataInputStream dis = new DataInputStream(new FileInputStream("dis.txt"));
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readDouble());
        dis.close();
    }
}
