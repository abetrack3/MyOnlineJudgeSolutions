import java.util.Scanner;
public class Problem1020
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int x=puttingvaluesinside.nextInt();
    System.out.println(x/365+" ano(s)");
    x%=365;
    System.out.println(x/30+" mes(es)\n"+x%30+" dia(s)");
  }
}