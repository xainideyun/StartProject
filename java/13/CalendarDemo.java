package pack12;
import java.util.*;
import java.text.*;
class CalendarDemo
{
  public static void main(String[] args)
  {
    Date d = new Date();
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    // String str = sdf.format(d);
    // System.out.println(str);
    // Calendar c = new GregorianCalendar();
    Calendar c = Calendar.getInstance();
    // System.out.println(c);
    // System.out.println(c.get(Calendar.YEAR));
    System.out.println(c.get(7));
    // System.out.println(c.get(Calendar.DAY_OF_YEAR));

  }
}
