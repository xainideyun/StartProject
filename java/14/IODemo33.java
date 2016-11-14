package pack13;
import java.io.*;
class IODemo33{
    public static void main(String[] args) throws IOException {
        // �ܵ�������ϰ������ܵ���ȡ����̨¼����Ϣ��д�뵽�ܵ��У�����ܵ����������ֽڴ�ӡ������̨
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
            System.out.println("�������������������...");
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
            System.out.println("��ʼ��������...");
            while(true){
                line = in.readLine();
                pos.write(line.getBytes());
                pos.flush();
            }
        }
        catch(Exception e){
            System.out.println("������������������...");
        }
    }
    public void close() throws IOException{
        this.pos.close();
        this.in.close();
    }
}
