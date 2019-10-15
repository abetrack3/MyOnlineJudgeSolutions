import java.util.Scanner;
public class Problem1019
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int x=puttingvaluesinside.nextInt();
    System.out.print(x/3600+":");
    x%=3600;
    System.out.println(x/60+":"+x%60);
  }
}