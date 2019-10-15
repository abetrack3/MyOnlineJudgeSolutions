import java.util.Scanner;
public class Problem1116
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    for(int c=puttingvaluesinside.nextInt(),a,b;c>0;c--)
    {
      a=puttingvaluesinside.nextInt();
      b=puttingvaluesinside.nextInt();
      if(b==0) System.out.println("divisao impossivel");
      else System.out.printf("%.1f\n",(float)a/b);
    }
  }
}