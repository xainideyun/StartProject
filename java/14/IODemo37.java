package pack13;
import java.util.*;
class IODemo37{
    public static void main(String[] args) throws Exception {
        String str = "��ͨ";
        byte[] buffer = str.getBytes("utf-8");
        for(byte b : buffer){
            System.out.println(Integer.toBinaryString(b & 255));
        }
    }
}
