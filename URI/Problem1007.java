import java.util.Scanner;
public class Problem1007
{
  public static void main (String[]args)
  {
    Scanner puttingvalueinside = new Scanner (System.in);
    int A = puttingvalueinside.nextInt();
    int B = puttingvalueinside.nextInt();
    int C = puttingvalueinside.nextInt();
    int D = puttingvalueinside.nextInt();
    int DIFERENCA = A * B - C * D;
    System.out.print("DIFERENCA = " + DIFERENCA);
    System.out.println();
  }
}