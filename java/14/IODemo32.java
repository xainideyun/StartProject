package pack13;
import java.io.*;

class IODemo32{
    public static void main(String[] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);
        Read r = new Read(pis);
        Write w = new Write(pos);
        new Thread(r).start();
        new Thread(w).start();
    }
}

class Read implements Runnable{
    private PipedInputStream pis;
    Read(PipedInputStream p){
        this.pis = p;
    }
    public void run(){
        try{
            System.out.println("读取前，没有数据，阻塞...");
            byte[] buffer = new byte[1024];
            int len = pis.read(buffer);
            System.out.println("读到数据，阻塞结束...");
            System.out.println(new String(buffer,0 ,len));
            pis.close();
        }
        catch(Exception e){
            System.out.println("管道输入流失败...");
        }
    }
}

class Write implements Runnable{
    private PipedOutputStream pos;
    Write(PipedOutputStream p){
        this.pos = p;
    }
    public void run(){
        try{
            System.out.println("等待6秒，再写入...");
            Thread.sleep(6000);
            System.out.println("管道输出流数据...");
            pos.write(97);
            pos.close();
        }
        catch(Exception e){
            System.out.println("管道流输出失败...");
        }
    }
}
