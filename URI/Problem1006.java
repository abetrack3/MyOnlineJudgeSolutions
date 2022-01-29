import java.util.Scanner;
public class Problem1006
{
  public static void main (String[]args)
  {
    Scanner puttingvalueinside = new Scanner (System.in);
    double A = puttingvalueinside.nextDouble();
    double B = puttingvalueinside.nextDouble();
    double C = puttingvalueinside.nextDouble();
    double MEDIA = A / 5 + B * 3 / 10 + C / 2;
    System.out.printf("MEDIA = %.1f", MEDIA);
    System.out.println();
  }
}