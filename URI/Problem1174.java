import java.util.Scanner;
public class Problem1174
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float b=0;
    for(int c=0;c<100;c++)
    {
      b=puttingvaluesinside.nextFloat();
      if(b<=10) System.out.println("A["+c+"] = "+b);
    }
  }
}