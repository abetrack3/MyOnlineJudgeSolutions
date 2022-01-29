import java.util.Scanner;
public class Problem1015
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double x1=puttingvaluesinside.nextDouble();
    double y1=puttingvaluesinside.nextDouble();
    x1-=puttingvaluesinside.nextDouble();
    y1-=puttingvaluesinside.nextDouble();
    //double x2=puttingvaluesinside.nextDouble();
    //double y2=puttingvaluesinside.nextDouble();
    //System.out.printf("%.4f\n",Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
    System.out.printf("%.4f\n",Math.sqrt(x1*x1+y1*y1));
  }
}