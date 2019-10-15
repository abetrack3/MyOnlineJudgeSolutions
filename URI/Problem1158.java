import java.util.Scanner;
public class Problem1158
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    for(int c=puttingvaluesinside.nextInt();c>0;c--)
    {
      int a=puttingvaluesinside.nextInt(), n=puttingvaluesinside.nextInt();
      if(a%2==0) a++;
      System.out.println(n*(a+n-1));
    }
  }
}