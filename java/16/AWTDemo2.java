package pack16;
import java.awt.*;
import java.awt.event.*;
class AWTDemo2{
    public static void main(String[] args) {
        //�����֣�window��action��mouse��key�¼�����
        new MyFrameCls();
    }
}

class MyFrameCls{
    private Frame f;
    private Button b;
    private Button b2;
    private TextField tf;
    MyFrameCls(){
        init();
    }
    private void init(){
        f = new Frame("�ҵĵ���");
        f.setBounds(200, 100, 500, 400);
        f.setLayout(new FlowLayout());
        b = new Button("ȷ��");
        f.add(b);
        b2 = new Button("ȷ��2");
        f.add(b2);
        tf = new TextField(10);
        f.add(tf);
        eventInit();
        f.setVisible(true);
    }
    private void eventInit(){
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        f.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                System.out.println("�ҽ�����...");
            }
        });
        b2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                System.out.println("���Ǽ��̣��Ұ�����!");
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        });
        tf.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() >= KeyEvent.VK_0 && e.getKeyCode() <= KeyEvent.VK_9){

                }
                else {
                    System.out.println(e.getKeyChar() + "...." + e.getKeyCode() + ".....�Ƿ�");
                    e.consume();
                }
            }
        });
    }
}
