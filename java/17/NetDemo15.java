package pack17;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
class NetDemo15{
    private static Frame f;
    private static Button b;
    private static Button submit;
    private static TextField ft;
    private static TextArea fa;
    private static Socket s;
    private static OutputStream os;
    public static void main(String[] args) throws Exception {
        // 发送文件【客户端】
        s = new Socket("localhost", 6008);
        os = s.getOutputStream();
        f = new Frame("发送文件客户端");
        f.setBounds(200, 100, 500, 300);
        f.setLayout(new FlowLayout());
        b = new Button("浏览");
        submit = new Button("上传");
        ft = new TextField(20);
        fa = new TextArea(10, 50);
        f.add(ft);
        f.add(b);
        f.add(submit);
        f.add(fa);
        initEvent();
        f.setVisible(true);
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    try{
                        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        fa.append("正在读取返回数据.........");
                        String msg = br.readLine();
                        if(msg == null)break;
                        fa.append(msg);
                    }
                    catch(Exception e){
                        fa.append("获取服务器返回信息出错...");
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
    private static void initEvent(){
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                FileDialog fd = new FileDialog(f, "选择文件...", FileDialog.LOAD);
                fd.setVisible(true);
                String path = fd.getDirectory() + fd.getFile();
                ft.setText(path);
            }
        });
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    FileInputStream fis = new FileInputStream(ft.getText());
                    byte[] buffer = new byte[1024 * 1024];
                    int len = fis.read(buffer);
                    os.write(buffer, 0, len);
                    s.shutdownOutput();
                    fis.close();
                    fa.append("发送成功...");
                }
                catch(Exception ex){
                    fa.append("发送错误...");
                    throw new RuntimeException(ex);
                }
            }
        });
    }







}
