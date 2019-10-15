import java.util.Scanner;
public class Problem1009
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    puttingvaluesinside.nextLine();
    Double x=puttingvaluesinside.nextDouble();
    x+=0.15*(puttingvaluesinside.nextDouble());
    System.out.print("TOTAL = R$ ");
    System.out.printf("%.2f",x);
    System.out.println();
  }
}