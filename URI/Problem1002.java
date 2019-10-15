import java.util.Scanner;
public class Problem1002
{
  public static void main (String[]args)
  {
    Scanner puttingvalueinside = new Scanner (System.in);
    double pi = 3.14159;
    double R = puttingvalueinside.nextDouble();
    double A = pi*R*R;
    System.out.printf("A=%.4f\n",A);
//    System.out.printf("A=%.4f%n",A);
//    System.out.println();
  }
}