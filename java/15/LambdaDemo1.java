package pack15;
class LambdaDemo1{
  public static void main(String[] args) {
    BuguBird bb = new BuguBird();
    bb.eat();
    bb.fly();
  }
}

interface Bird {
  void eat();
  default void fly(){
    System.out.println("I can fly...");
  }
}

class BuguBird implements Bird{
  @Override
  public void eat()
  {
    System.out.println("我是布谷鸟，我正在吃东西...");
  }
}
