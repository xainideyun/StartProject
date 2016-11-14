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
            System.out.println("��ȡǰ��û�����ݣ�����...");
            byte[] buffer = new byte[1024];
            int len = pis.read(buffer);
            System.out.println("�������ݣ���������...");
            System.out.println(new String(buffer,0 ,len));
            pis.close();
        }
        catch(Exception e){
            System.out.println("�ܵ�������ʧ��...");
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
            System.out.println("�ȴ�6�룬��д��...");
            Thread.sleep(6000);
            System.out.println("�ܵ����������...");
            pos.write(97);
            pos.close();
        }
        catch(Exception e){
            System.out.println("�ܵ������ʧ��...");
        }
    }
}
