import java.util.Scanner;
public class Problem1153
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    System.out.println(factorial(puttingvaluesinside.nextInt()));
  }
  public static int factorial(int m)
  {
    if(m==1) return 1;
    else return m*factorial(m-1);
  }
}
