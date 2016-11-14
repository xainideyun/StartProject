package pack16;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class AWTDemo4{
    public static void main(String[] args) {
        // 制作菜单、文本编辑器
        new MyMenuCls();
    }
}

class MyMenuCls{
    private Frame f;
    private MenuBar mb;
    private Menu m, m2;
    private MenuItem mi, mi3, mi4;
    private TextArea ta;
    private FileDialog fd;
    private Dialog d;
    private Label l;
    private Button b;
    MyMenuCls(){
        init();
    }
    private void init(){
        f = new Frame("我的窗口-菜单");
        f.setBounds(200, 200, 600, 500);
        // f.setLayout(new FlowLayout());

        mb = new MenuBar();
        m = new Menu("文件");
        mi = new MenuItem("退出");
        m2 = new Menu("子菜单");
        mi3 = new MenuItem("打开");
        mi4 = new MenuItem("保存");
        ta = new TextArea();
        d = new Dialog(f, "提示", true);
        d.setBounds(300, 300, 400, 100);
        l = new Label();
        b = new Button("确定");
        d.add(l);
        d.add(b);
        mb.add(m);
        m.add(m2);
        m.add(mi);
        m2.add(mi3);
        m2.add(mi4);

        f.setMenuBar(mb);
        f.add(ta);
        initEvent();

        f.setVisible(true);
    }
    private void initEvent(){
        mi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
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
                d.setVisible(false);
            }
        });
        mi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    fd = new FileDialog(f, "选择文件", FileDialog.LOAD);
                    fd.setVisible(true);
                    if(fd.getFile() == null)return;
                    String filePath = fd.getDirectory() + fd.getFile();
                    BufferedReader br = new BufferedReader(new FileReader(filePath));
                    String line = null;
                    ta.setText("");
                    while((line = br.readLine()) != null){
                        ta.append(line + "\r\n");
                    }
                    br.close();
                }
                catch(Exception ex){
                    l.setText("读取文件错误...");
                    d.setVisible(true);
                }
            }
        });
        mi4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{

                    fd = new FileDialog(f, "选择保存路径", FileDialog.SAVE);
                    fd.setVisible(true);
                    if(fd.getFile() == null) return;
                    String filePath = fd.getDirectory() + fd.getFile();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
                    bw.write(ta.getText());
                    bw.close();
                }
                catch(Exception ex){
                    l.setText("保存文件失败...");
                    d.setVisible(true);
                }
            }
        });
    }
}
