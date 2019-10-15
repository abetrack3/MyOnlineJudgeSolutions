import java.util.Scanner;
public class Problem1010
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int y=puttingvaluesinside.nextInt();
    double x=puttingvaluesinside.nextDouble();
    x*=puttingvaluesinside.nextDouble();
    double sum=x;
    y=puttingvaluesinside.nextInt();
    x=puttingvaluesinside.nextDouble();
    x*=puttingvaluesinside.nextDouble();
    sum+=x;
    System.out.printf("VALOR A PAGAR: R$ %.2f%n",sum);
  }
}