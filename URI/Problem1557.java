import java.util.Scanner;
public class Problem1557
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    String s=puttingvaluesinside.nextLine().trim();
    int n=Integer.parseInt(s),m=0,t=(""+(int)Math.pow(2,2*(n-1))).length();
    while(n!=0)
    {
      for(int a=0;a<n;a++)
      {
        m=(int)Math.pow(2,a);
        for(int b=0;b<n;b++)
        {
          for(int d=(""+m).length();d<t;d++) System.out.print(" ");
          System.out.print(m);
          m*=2;
          if(b==n-1) System.out.println();
          else System.out.print(" ");
        }
      }
      System.out.println();
      s=puttingvaluesinside.nextLine().trim();
      n=Integer.parseInt(s);
      t=(""+(int)Math.pow(2,2*(n-1))).length();
    }
  }
}