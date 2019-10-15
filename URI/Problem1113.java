import java.util.Scanner;
public class Problem1113
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    int a=puttingvaluesinside.nextInt();
    int b=puttingvaluesinside.nextInt();
    while(a!=b)
    {
      if(a>b) System.out.println("Decrescente");
      else System.out.println("Crescente");
      a=puttingvaluesinside.nextInt();
      b=puttingvaluesinside.nextInt();
    }
  }
}