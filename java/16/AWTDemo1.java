package pack16;
import java.awt.*;
import java.awt.event.*;
class AWTDemo1{
    public static void main(String[] args) {
        // ����ͼ�λ�����
        // 1. ����Frame����
        // 2.�Դ�����л�������
        // 3. ����������������ӵ�������
        // 4. ��ʾ����
        Frame f = new Frame("�ҵ�����");
        f.setSize(500, 400);
        f.setLocation(100, 100);
        f.setLayout(new FlowLayout());
        Button b = new Button("ȷ��");
        f.add(b);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.out.println("�ر�");
                System.exit(0);
            }
        });

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        f.setVisible(true);
    }
}
