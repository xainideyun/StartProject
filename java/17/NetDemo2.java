package pack17;
import java.net.*;
class NetDemo2{
    public static void main(String[] args) throws Exception {
        // Socket��ϰ������
        // 1.ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ
        // 2.�ṩ���ݣ��������ݷ�װ�����ݰ���
        // 3. ͨ��socket����ķ��͹��ܽ����ݷ��ͳ�ȥ
        // 4. �ر���Դ

        DatagramSocket ds = new DatagramSocket();
        byte[] buffer = "�ҷ��͵�����...".getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 6001);
        ds.send(dp);
        ds.close();
    }
}
