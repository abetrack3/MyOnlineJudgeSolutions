import java.util.Scanner;
public class Problem1074
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int c=0,d=0;c<a;c++)
    {
      d=puttingvaluesinside.nextInt();
      if(d==0)
      {
        System.out.println("NULL");
      }
      else
      {
        if(d%2==0) System.out.print("EVEN ");
        else System.out.print("ODD ");
        if(d>0) System.out.println("POSITIVE");
        else System.out.println("NEGATIVE");
      }
    }
  }
}