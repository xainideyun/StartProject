package pack17;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
class NetDemo6{
    private static Frame f;
    private static TextField tf;
    private static TextArea ta;
    private static Button b;
    private static DatagramSocket dsSend;
    private static DatagramSocket dsRece;
    public static void main(String[] args) throws Exception {
        // 发送聊天消息
        init();
    }
    public static void init() throws Exception{
        f = new Frame("聊天窗口...");
        f.setLayout(new FlowLayout());
        f.setBounds(200, 200, 600, 500);
        tf = new TextField(20);
        f.add(tf);
        b = new Button("发送");
        f.add(b);
        ta = new TextArea(20, 70);
        f.add(ta);
        initEvent();
        f.setVisible(true);

        dsSend = new DatagramSocket();
        dsRece = new DatagramSocket(6003);
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    try{
                        dsRece.receive(dp);
                        ta.append(new String(dp.getData(), 0, dp.getLength()) + "\r\n");
                    }
                    catch(Exception e){
                        throw new RuntimeException("出错了：" + e);
                    }
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
        tf.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    send();
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                send();
            }
        });
    }
    private static void send(){
        try{
            byte[] info = tf.getText().getBytes();
            DatagramPacket dp = new DatagramPacket(info, info.length, InetAddress.getByName("10.70.12.255"), 6003);
            dsSend.send(dp);
            tf.setText("");
        }
        catch(Exception e){
            throw new RuntimeException("出错了" + e);
        }
    }
}
