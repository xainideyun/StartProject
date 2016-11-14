package pack17;
import java.net.*;
class NetDemo2{
    public static void main(String[] args) throws Exception {
        // Socket练习，发送
        // 1.通过udp传输方式，将一段文字数据发送出去
        // 2.提供数据，并将数据封装到数据包中
        // 3. 通过socket服务的发送功能将数据发送出去
        // 4. 关闭资源

        DatagramSocket ds = new DatagramSocket();
        byte[] buffer = "我发送的数据...".getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 6001);
        ds.send(dp);
        ds.close();
    }
}
