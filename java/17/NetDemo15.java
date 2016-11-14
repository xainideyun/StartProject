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
        // �����ļ����ͻ��ˡ�
        s = new Socket("localhost", 6008);
        os = s.getOutputStream();
        f = new Frame("�����ļ��ͻ���");
        f.setBounds(200, 100, 500, 300);
        f.setLayout(new FlowLayout());
        b = new Button("���");
        submit = new Button("�ϴ�");
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
                        fa.append("���ڶ�ȡ��������.........");
                        String msg = br.readLine();
                        if(msg == null)break;
                        fa.append(msg);
                    }
                    catch(Exception e){
                        fa.append("��ȡ������������Ϣ����...");
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
                FileDialog fd = new FileDialog(f, "ѡ���ļ�...", FileDialog.LOAD);
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
                    fa.append("���ͳɹ�...");
                }
                catch(Exception ex){
                    fa.append("���ʹ���...");
                    throw new RuntimeException(ex);
                }
            }
        });
    }







}
