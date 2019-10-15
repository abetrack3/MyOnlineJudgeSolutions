import java.util.Scanner;
public class Problem1005
{
  public static void main (String[]args)
  {
    Scanner puttingvalueinside = new Scanner (System.in);
    double A = puttingvalueinside.nextDouble();
    double B = puttingvalueinside.nextDouble();
    double MEDIA = A * 3.5 / 11 + B * 7.5 / 11;
    System.out.printf("MEDIA = %.5f", MEDIA);
    System.out.println();
  }
}