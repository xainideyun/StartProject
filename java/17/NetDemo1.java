package pack17;
import java.net.*;
class NetDemo1{
    public static void main(String[] args) throws Exception {
        // ÍøÂç±à³ÌIPµØÖ·Á·Ï°
        // InetAddress ia = InetAddress.getLocalHost();
        // System.out.println(ia);

        // InetAddress ia = InetAddress.getByName("10.70.18.22");
        // System.out.println(ia);
        // System.out.println("name=" + ia.getHostName());
        // System.out.println("ip=" + ia.getHostAddress());

        InetAddress[] ias = InetAddress.getAllByName("www.baidu.com");
        int len = 1;
        for(InetAddress ia : ias){
            System.out.println("name" + len + "=" + ia.getHostName());
            System.out.println("ip" + len + "=" + ia.getHostAddress());
            len++;
        }
    }
}
