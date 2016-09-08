package pack12;
import java.util.*;
class CalendarDemo2
{
  public static void main(String[] args)
  {
    System.out.println(getTwoMonthDays(2220));
  }

  public static int getTwoMonthDays(int year)
  {
    Calendar c = Calendar.getInstance();
    c.set(year,2,1);
    c.add(Calendar.DAY_OF_MONTH, -1);
    return c.get(Calendar.DAY_OF_MONTH);
  }
}
