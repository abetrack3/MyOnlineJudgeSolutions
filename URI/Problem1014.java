import java.util.Scanner;
public class Problem1014
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double X=puttingvaluesinside.nextDouble();
    X/=puttingvaluesinside.nextDouble();
    System.out.printf("%.3f km/l\n",X);
  }
}