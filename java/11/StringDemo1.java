package pack9;
class StringDemo1
{
  public static void main(String[] args)
  {
    String str = "      Àî¾ê¾ê      ";
    System.out.println("-"+str+"-");
    System.out.println("-" + myTrim(str) + "-");
  }
  public static String myTrim(String str)
  {
    int start = 0,end = str.length() - 1;
    while(start <= end && str.charAt(start) == ' ')
      start++;
    while(end > 0 && str.charAt(end) == ' ')
      end--;
    return str.substring(start,end+1);
  }

}
