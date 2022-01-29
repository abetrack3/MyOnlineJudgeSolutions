public class Problem1096
{
  public static void main (String[]args)
  {
    for(int a=1,b=7,c=1;1>0;a++,b--)
    {
      System.out.println("I="+c+" J="+b);
      if(c==9&&b==5) break;
      else if(a%3==0)
      {
        c+=2; b=8;
      }
    }
  }
}