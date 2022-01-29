import java.util.Scanner;
public class Problem1008
{
  public static void main (String[]args)
  {
    Scanner puttingvalueinside=new Scanner (System.in);
    int x=puttingvalueinside.nextInt();
    double y=puttingvalueinside.nextInt();
    y*=puttingvalueinside.nextDouble();
    System.out.println("NUMBER = "+x);
    System.out.print("SALARY = U$ ");
    System.out.printf("%.2f%n",y);
  }
}