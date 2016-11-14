package pack13;
import java.io.*;
import java.util.*;
class IODemo24{
    // 建立一个java文件列表
    public static void main(String[] args) throws IOException {
        List<File> list = new ArrayList<File>();
        fileToArr(new File("G:\\Start\\StartProject\\java"), list);
        // for(File file : list){
        //     System.out.println(file);
        // }
        writeToFile(list, "G:\\list20161025.txt");
    }
    public static void fileToArr(File dir, List<File> list){
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                fileToArr(file, list);
            }
            else{
                if(file.getName().toLowerCase().endsWith(".java"))
                    list.add(file);
            }
        }
    }
    public static void writeToFile(List<File> files, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for(File file : files){
            bw.write(file.toString());
            bw.newLine();
            bw.flush();
        }
    }

}
