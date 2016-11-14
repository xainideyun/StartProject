package pack16;
import java.awt.*;
import java.awt.event.*;
class AWTDemo1{
    public static void main(String[] args) {
        // 创建图形化界面
        // 1. 创建Frame窗体
        // 2.对窗体进行基础设置
        // 3. 定义组件，将组件添加到窗体中
        // 4. 显示窗体
        Frame f = new Frame("我的桌面");
        f.setSize(500, 400);
        f.setLocation(100, 100);
        f.setLayout(new FlowLayout());
        Button b = new Button("确定");
        f.add(b);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.out.println("关闭");
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
