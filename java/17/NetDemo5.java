package pack17;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
class NetDemo5{
    private static Frame f ;
    private static TextArea ta ;
    private static DatagramSocket ds;
    private static DatagramPacket dp;
    public static void main(String[] args) throws Exception {
        // UDP���ն˴�����ϰ
        init();
    }
    public static void init() throws Exception {
        f = new Frame("���ǽ��ն�...");
        ta = new TextArea();
        f.setBounds(200, 200, 600, 500);
        f.add(ta);
        initEvent();
        f.setVisible(true);

        ds = new DatagramSocket(6002);
        dp = new DatagramPacket(new byte[1024], 1024);
        new Thread(new Runnable(){
            public void run(){
                try{
                    while(true){
                        ds.receive(dp);
                        ta.append(new String(dp.getData(), 0, dp.getLength()));
                        ta.append("\r\n");
                    }
                }
                catch(Exception e){
                    System.out.println("���ն˳�����...");
                }
            }
        }).start();
    }
    public static void initEvent(){
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
