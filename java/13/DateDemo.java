package pack12;
import java.text.*;
import java.util.*;
class DateDemo
{
  public static void main(String[] args)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(sdf.format(new Date()));
  }
}
