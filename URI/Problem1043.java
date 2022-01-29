import java.util.Scanner;
import java.util.Arrays;
public class Problem1043
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float a[]=
    {
      puttingvaluesinside.nextFloat(),
      puttingvaluesinside.nextFloat(),
      puttingvaluesinside.nextFloat()
    };
    float b[]=a.clone();
    Arrays.sort(a);
    if((a[0]+a[1])>a[2])
    {
      System.out.printf("Perimetro = %.1f\n", (a[0]+a[1]+a[2]));
    }
    else
    {
      System.out.printf("Area = %.1f\n",.5*(b[0]+b[1])*b[2]);
    }
  }
}