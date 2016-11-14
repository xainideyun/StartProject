package pack13;
import java.io.*;

class IODemo23{
    // 递归删除一个目录下的文件
    public static void main(String[] args) throws IOException {
        deleteDir(new File("G:\\ABC"));
    }
    public static void deleteDir(File f){
        File[] files = f.listFiles();
        for(File file : files){
            if(file.isDirectory())
                deleteDir(file);
            file.delete();
        }
    }
}
