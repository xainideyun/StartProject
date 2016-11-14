package pack13;
import java.io.*;
import java.util.*;
class IODemo26{
    public static void main(String[] args) throws IOException {
        // 设计程序运行的次数
        String filename = "program.ini";
        File file = new File(filename);
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader fr = new FileReader(file);
        Properties ps = new Properties();
        ps.load(fr);
        String count = ps.getProperty("time");
        System.out.println(count);
        int time = count == null ? 0 : Integer.parseInt(count);
        time++;
        ps.setProperty("time", time + "");
        FileWriter fw = new FileWriter(file);
        ps.store(fw, "execute time");
        fr.close();
        fw.close();
    }
}
