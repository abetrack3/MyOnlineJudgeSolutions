import java.util.Scanner;
public class Problem1035
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int A,B,C,D;
    A=puttingvaluesinside.nextInt();
    B=puttingvaluesinside.nextInt();
    C=puttingvaluesinside.nextInt();
    D=puttingvaluesinside.nextInt();
    if((B>C)&&(D>A)&&(C+D>A+B)&&(C>=0)&&(D>=0)&&(A%2==0))
    {
      System.out.println("Valores aceitos");
    }
    else
    {
      System.out.println("Valores nao aceitos");
    }
  }
}