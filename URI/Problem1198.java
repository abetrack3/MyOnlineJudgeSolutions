import java.util.Scanner;
public class Problem1198
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    long a[]=new long[2];
    while(puttingvaluesinside.hasNextLine())
    {
      a[0]=puttingvaluesinside.nextLong(); a[1]=puttingvaluesinside.nextLong();
      puttingvaluesinside.nextLine();
      if(a[1]>a[0]) System.out.println(a[1]-a[0]);
      else System.out.println(a[0]-a[1]);
    }
  }
}