import java.util.Scanner;
public class Problem1044
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(), b=puttingvaluesinside.nextInt();
    if((a%b==0)||(b%a==0))
    {
      System.out.println("Sao Multiplos");
    }
    else
    {
      System.out.println("Nao sao Multiplos");
    }
  }
}