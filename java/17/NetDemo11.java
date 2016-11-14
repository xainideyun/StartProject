package pack17;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
class NetDemo11{
    public static void main(String[] args) {
        // 网络传输文件练习（发送端）
        new FrameSend("localhost", 6006);
    }
}
class FrameSend{
    private Frame f;
    private Button b;
    private Button bLoad;
    private TextField tf;
    private FileDialog fd;
    private Socket s;
    private OutputStream os;
    FrameSend(String ip, int port) {
        try{
            s = new Socket(ip, port);
            os = s.getOutputStream();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        init();
    }
    private void init(){
        f = new Frame();
        f.setBounds(200, 100, 900, 500);
        f.setLayout(new FlowLayout());
        tf = new TextField(50);
        b = new Button("选择...");
        bLoad = new Button("上传...");
        f.add(tf);
        f.add(b);
        f.add(bLoad);
        initEvent();
        f.setVisible(true);
    }
    private void initEvent(){
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fd = new FileDialog(f, "选择文件", FileDialog.LOAD);
                fd.setVisible(true);
                if(fd.getFile() == null)return;
                String filePath = fd.getDirectory() + fd.getFile();
                tf.setText(filePath);

            }
        });
        bLoad.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String filePath = tf.getText();
                File file = new File(filePath);
                if(!file.exists())return;
                try{
                    InputStream is = new FileInputStream(filePath);
                    byte[] buffer = new byte[1024 * 1024];
                    int len = 0;
                    while((len = is.read(buffer)) > -1){
                        os.write(buffer, 0, len);
                    }
                    is.close();
                }
                catch(Exception event){

                }

                tf.setText("发送成功...");
            }
        });
    }
}
