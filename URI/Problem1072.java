import java.util.Scanner;
public class Problem1072
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    int d=0,e=0;
    for(int c=0,b=0;c<a;c++)
    {
      b=puttingvaluesinside.nextInt();
      if(b>=10&&b<=20) d++;
      else e++;
    }
    System.out.println(d+" in\n"+e+" out");
  }
}