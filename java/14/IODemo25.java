package pack13;
import java.io.*;
import java.util.*;
class IODemo25{
    public static void main(String[] args) throws IOException {
        /*
        // Properties介绍
        Properties ps = new Properties();
        ps.setProperty("name", "孙小双");
        ps.setProperty("age", "28");
        // ps.list(System.out);
        Set<String> names = ps.stringPropertyNames();
        for(String name : names){
            System.out.println(name + "=" + ps.getProperty(name));
        }
        */
        /*
        // 将文件以键值对的方式加载到Properties中，自己解析文件
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
        // 直接使用加载方法加载字符流
        Properties ps = new Properties();
        ps.load(new FileReader("info.txt"));
        ps.list(System.out);
        */
        // 保存属性信息
        Properties ps = new Properties();
        FileReader fr = new FileReader("info.txt");
        FileWriter fw = new FileWriter("info_2.txt");
        ps.load(fr);
        ps.setProperty("code", "sunxsh");
        ps.store(fw, "新增加属性");
        fr.close();
        fw.close();
    }
}
