import java.util.Scanner;
public class Problem1073
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int c=2;c<=a;c+=2)
    {
      System.out.println(c+"^2 = "+c*c);
    }
  }
}