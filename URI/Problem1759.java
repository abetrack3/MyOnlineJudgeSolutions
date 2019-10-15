import java.util.Scanner;
public class Problem1759
{
  public static void main (String[]args)
  {
    int n=new Scanner(System.in).nextInt();
    for(int a=1;a<=n;a++)
    {
      System.out.print("Ho");
      if(a!=n) System.out.print(" ");
      else System.out.println("!");
    }
  }
}