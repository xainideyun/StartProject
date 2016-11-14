package pack13;
import java.io.*;
import java.util.*;
class IODemo36{
    public static void main(String[] args) throws Exception {
        // String str = "ÄãºÃ";
        // byte[] buffer = str.getBytes();
        // System.out.println(Arrays.toString(buffer));
        // System.out.println(new String(buffer, "utf-8"));

        String str = "ÄãºÃ";
        byte[] buffer = str.getBytes("utf-8");
        System.out.println(Arrays.toString(buffer));
        System.out.println(new String(buffer, "gbk"));

    }
}
