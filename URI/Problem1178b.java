import java.util.Scanner;
public class Problem1178b
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double a=puttingvaluesinside.nextDouble(); //String s="";
    for(int b=0;b<100;b++)
    {
      System.out.printf("N[%d] = %.4f\n",b,a/Math.pow(2,b));
    }
  }
}