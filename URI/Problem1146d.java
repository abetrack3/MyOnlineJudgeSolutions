import java.util.Scanner;
public class Problem1146d
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=1, b=puttingvaluesinside.nextInt();
    while(b!=0)
    {
      System.out.print(a);
      if(a==b)
      {
        System.out.println();
        a=1;
        b=puttingvaluesinside.nextInt();
      }
      else
      {
        System.out.print(" ");
        a++;
      }
    }
  }
}