package pack17;
import java.io.*;
import java.net.*;
class NetDemo19{
    public static void main(String[] args) throws Exception {
        // ģ���û���¼���ͻ��ˣ�
        Socket s = new Socket("localhost", 6010);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader brFeed = new BufferedReader(new InputStreamReader(s.getInputStream()));

        for (int i = 0; i < 3; i++) {
            String name = br.readLine();
            if(name == null)
                break;
            pw.println(name);
            String feed = brFeed.readLine();
            if(feed == "0"){
                System.out.println("��¼�ɹ�...");
                break;
            }
            else {
                if(i == 2){
                    System.out.println("���ε�¼���ɹ�����ʮ���Ӻ��ٵ�¼...");
                }
                else {
                    System.out.println("��¼ʧ�ܣ�������...");
                }
            }
        }

        s.close();
    }
}
