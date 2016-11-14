package pack17;
import java.net.*;
class NetDemo3{
    public static void main(String[] args) throws Exception {
        // Socket¡∑œ∞£¨Ω” ’
        DatagramSocket ds = new DatagramSocket(6001, InetAddress.getByName("localhost"));
        DatagramPacket dp = new DatagramPacket(new byte[1024*1024], 1024*1024);
        ds.receive(dp);
        System.out.println(new String(dp.getData(), 0,dp.getLength()));
        // System.out.println(dp.getLength());
        ds.close();
    }
}
