package pack15;
class LambdaDemo2 {
  public static void main(String[] args) {
    new Thread(() -> {
      while(true){
        System.out.println("����ͨ��Lambda������...");
        try{
          Thread.sleep(2000);
        }
        catch(Exception e){

        }
      }
    }).start();
  }

}
