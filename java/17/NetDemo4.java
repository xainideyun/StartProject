package pack17;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
class NetDemo4{
    private static Frame f ;
    private static TextField tf ;
    private static Button b ;
    private static DatagramSocket ds;
    private static DatagramPacket dp;
    public static void main(String[] args) throws Exception {
        // UDP���Ͷ˴�����ϰ
        init();
    }

    public static void init() throws Exception {
        f = new Frame("���Ƿ��Ͷ�...");
        tf = new TextField(20);
        b = new Button("����");
        f.setBounds(200, 200, 600, 500);
        f.setLayout(new FlowLayout());
        f.add(tf);
        f.add(b);
        initEvent();
        f.setVisible(true);

        ds = new DatagramSocket();
    }
    public static void initEvent(){
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                send();
            }
        });
        tf.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    send();
                }
            }
        });
    }
    public static void send() {
        byte[] buffer = tf.getText().getBytes();
        try{
            dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 6002);
            ds.send(dp);
        }
        catch(Exception e){
            System.out.println("���Ͷ˳�����...");
            return;
        }
        tf.setText("");
    }
}
