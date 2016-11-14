package pack15;
import java.util.*;
class LambdaDemo5{
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2,2,34,5,6,7);
    // for(int number : list){
    //   System.out.println(number + " :: " + Thread.currentThread().getName());
    // }
    list.forEach(a -> System.out.println(a + "::" + Thread.currentThread().getName()));
  }
}
