import java.util.Scanner;
public class Problem1078
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int c=1;c<=10;c++)
      System.out.println(c+" x "+a+" = "+c*a);
  }
}