import java.util.Scanner;
public class Problem1142
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int c=1;c<=4*a;c++)
    {
      if(c%4==0) System.out.print("PUM\n");
      else System.out.print(c+" ");
    }
  }
}