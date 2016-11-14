package pack16;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class AWTDemo3{
    public static void main(String[] args) {
        // 制作资源管理器
        new MyWindowDemo();
    }
}
class MyWindowDemo{
    private Frame f;
    private Button b;
    private TextField tf;
    private TextArea ta;
    MyWindowDemo(){
        init();
    }
    private void init(){
        f = new Frame("我的窗口");
        f.setBounds(200, 200, 600, 500);
        f.setLayout(new FlowLayout());
        b = new Button("确定");
        tf = new TextField(50);
        ta = new TextArea(15, 80);
        f.add(tf);
        f.add(b);
        f.add(ta);
        initEvent();
        f.setVisible(true);
    }
    private void initEvent(){
        f.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
        });
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadDirectory(tf.getText());
            }
        });
        tf.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    loadDirectory(tf.getText());
            }
        });
    }
    private void loadDirectory(String path){
        File file = new File(path);
        if(!file.exists() || !file.isDirectory()){
            error(file.getPath());
            return;
        }
        File[] files = file.listFiles();
        StringBuilder sb = new StringBuilder();
        for(File f : files){
            sb.append(f.getPath() + "\r\n");
        }
        ta.setText(sb.toString());
    }
    private void error(String path){
        Dialog d = new Dialog(f, "错误提示", true);
        d.add(new Label("指定的文件夹【" + path + "】不存在"));
        Button b = new Button("确定");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                d.setVisible(false);
                d.setEnabled(true);
            }
        });
        d.add(b);
        d.setBounds(300,300, 300, 100);
        d.setLayout(new FlowLayout());
        d.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                d.setVisible(false);
                d.setEnabled(true);
            }
        });
        d.setVisible(true);
    }
}
