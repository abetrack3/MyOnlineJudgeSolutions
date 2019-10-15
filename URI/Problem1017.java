import java.util.Scanner;
public class Problem1017
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    a*=puttingvaluesinside.nextInt();
    System.out.printf("%.3f\n",a/12.0);
  }
}