import java.util.Scanner;
public class Problem1080
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(), b=1;
    for(int c=2,d=0;c<=100;c++)
    {
      d=puttingvaluesinside.nextInt();
      if(d>a)
      {
        a=d;
        b=c;
      }
    }
    System.out.println(a+"\n"+b);
  }
}