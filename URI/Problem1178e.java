//This code just proves that uDebug is not always right :v
import java.util.Scanner;
public class Problem1178e
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double a=puttingvaluesinside.nextDouble();
    double b[]=new double[100];
    for(int c=0;c<b.length;c++)
    {
      b[c]=a;
      System.out.printf("N[%d] = %.4f\n",c,a);
      a/=2.0;
    }
  }
}