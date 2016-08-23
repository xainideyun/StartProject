package pack9;
class StringDemo2
{
  public static void main(String[] args)
  {
    System.out.println(getMaxSubString("abhclijjsunxshllfke","mvmkwlijjqsunxshlwk"));
  }
  public static String getMaxSubString(String s1,String s2)
  {
    for (int start=0; start<s2.length();start++ )
    {
      for (int x=0,y=s2.length()-start; y<s2.length()+1; x++,y++)
      {
        String str = s2.substring(x,y);
        if(s1.contains(str))
          return str;
      }
    }
    return "";
  }
}
