import java.util.Scanner;
public class Problem1004
{
  public static void main (String[]args)
  {
    Scanner puttingvalueinside = new Scanner (System.in);
    int A = puttingvalueinside.nextInt();
    int B = puttingvalueinside.nextInt();
    int PROD = A * B;
    System.out.print("PROD = " + PROD);
    System.out.println();
  }
}