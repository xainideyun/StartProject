package pack13;
import java.io.*;
import java.util.*;
class IODemo25{
    public static void main(String[] args) throws IOException {
        /*
        // Properties����
        Properties ps = new Properties();
        ps.setProperty("name", "��С˫");
        ps.setProperty("age", "28");
        // ps.list(System.out);
        Set<String> names = ps.stringPropertyNames();
        for(String name : names){
            System.out.println(name + "=" + ps.getProperty(name));
        }
        */
        /*
        // ���ļ��Լ�ֵ�Եķ�ʽ���ص�Properties�У��Լ������ļ�
        BufferedReader br = new BufferedReader(new FileReader("info.txt"));
        Properties ps = new Properties();
        String str = "";
        while((str = br.readLine()) != null){
            String[] arr = str.split("=");
            ps.setProperty(arr[0], arr[1]);
        }
        br.close();
        ps.list(System.out);
        */
        /*
        // ֱ��ʹ�ü��ط��������ַ���
        Properties ps = new Properties();
        ps.load(new FileReader("info.txt"));
        ps.list(System.out);
        */
        // ����������Ϣ
        Properties ps = new Properties();
        FileReader fr = new FileReader("info.txt");
        FileWriter fw = new FileWriter("info_2.txt");
        ps.load(fr);
        ps.setProperty("code", "sunxsh");
        ps.store(fw, "����������");
        fr.close();
        fw.close();
    }
}
