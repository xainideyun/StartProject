package pack17;
import java.io.*;
import java.net.*;
class NetDemo13{
    public static void main(String[] args) throws Exception {
        // ��ϰ�ͻ��˷����ַ�������˽��գ���ת��Ϊ��д�󷵻ظ��ͻ���
        // �ͻ���
        Socket s = new Socket("localhost", 6007);
        PrintWriter ps = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

        String consoleReader = null;
        while((consoleReader = br1.readLine()) != null){
            if(consoleReader == "over")break;
            ps.println(consoleReader);
            System.out.println("����˻ط�����Ϣ��" + br.readLine());
        }
        s.close();
        br1.close();
    }
}
