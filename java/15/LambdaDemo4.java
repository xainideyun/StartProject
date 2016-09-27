package pack15;
class LambdaDemo4{
  public static void main(String[] args) {
    LambdaCls1 cl = new LambdaCls1("ÄãºÃÂð£¿");
    cl.printLoop();

  }
}

class LambdaCls1{
  private String msg;
  LambdaCls1(String str){
    msg = str;
  }
  public void print(){
    System.out.println(msg);
  }
  public void printLoop(){
    new Thread(this::print).start();
  }
}
