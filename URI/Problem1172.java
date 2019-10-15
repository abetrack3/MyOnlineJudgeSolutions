import java.util.Scanner;
public class Problem1172
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a[]=new int[10];
    for(int c=0;c<a.length;c++)
    {
      a[c]=puttingvaluesinside.nextInt();
      if(a[c]<=0) a[c]=1;
    }
    int c=0;
    for(int x:a)
    {
      System.out.println("X["+c+"] = "+x);
      c++;
    }
  }
}