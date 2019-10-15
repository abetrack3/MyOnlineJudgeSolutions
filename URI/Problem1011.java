import java.util.Scanner;
public class Problem1011
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double R=puttingvaluesinside.nextInt();
    R*=4.0/3*R*R*3.14159;
    System.out.printf("VOLUME = %.3f\n",R);
  }
}