package pack13;
import java.io.*;
class IODemo33{
    public static void main(String[] args) throws IOException {
        // 管道流的练习，输出管道读取控制台录入信息，写入到管道中；输入管道将读到的字节打印到控制台
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);
        ReadPiped r = new ReadPiped(pis);
        WritePiped w = new WritePiped(pos, new BufferedReader(new InputStreamReader(System.in)));
        new Thread(r).start();
        new Thread(w).start();
    }
}
class ReadPiped implements Runnable{
    private PipedInputStream pis;
    ReadPiped(PipedInputStream p){
        this.pis = p;
    }
    public void run(){
        try{
            byte[] buffer = new byte[1024];
            int len = 0;
            while(true){
                len = pis.read(buffer, 0, 1024);
                System.out.println(new String(buffer, 0, len).toUpperCase());
            }
        }
        catch(Exception e){
            System.out.println("这边是输入流，出错了...");
        }
    }
    public void close() throws IOException{
        this.pis.close();
    }
}
class WritePiped implements Runnable{
    private PipedOutputStream pos;
    private BufferedReader in;
    WritePiped(PipedOutputStream p, BufferedReader in){
        this.pos = p;
        this.in = in;
    }
    public void run(){
        try{
            String line = null;
            System.out.println("开始输入数据...");
            while(true){
                line = in.readLine();
                pos.write(line.getBytes());
                pos.flush();
            }
        }
        catch(Exception e){
            System.out.println("这边是输出流，出错了...");
        }
    }
    public void close() throws IOException{
        this.pos.close();
        this.in.close();
    }
}
