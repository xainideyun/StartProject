package pack17;
import java.io.*;
import java.net.*;
class NetDemo9{
    public static void main(String[] args) throws Exception {
        //����ϰ��
        //���ͻ��������ı������͸�����ˣ�����˷��ش�д����Ϣ����
        Socket s = new Socket("localhost", 6005);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream os = s.getOutputStream();
        String str = null;
        new Thread(new Runnable(){
            public void run(){
                byte[] buffer = new byte[1024];
                int len = 0;
                try{
                    InputStream is = s.getInputStream();
                    while((len = is.read(buffer)) > -1){
                        System.out.println(new String(buffer, 0, len));
                    }
                }
                catch(Exception e){
                    System.out.println("���Ͷ˳�����...");
                }
            }
        }).start();
        while(true){
            os.write(br.readLine().getBytes());
        }
    }
}
