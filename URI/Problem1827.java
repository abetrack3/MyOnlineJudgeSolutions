import java.util.Scanner;
public class Problem1827
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int n; int m[][];
    while(puttingvaluesinside.hasNextInt())
    {
      n=puttingvaluesinside.nextInt();
      puttingvaluesinside.nextLine();
      m=new int[n][n];
      for(int a=0;a<n;a++)
      {
        for(int b=0;b<n;b++)
        {
          if(a==b) m[a][b]=2;
          if(a+b==n-1) m[a][b]=3;
        }
      }
      for(int a=n/3;a<=n-1-n/3;a++)
      {
        for(int b=n/3;b<=n-1-n/3;b++) m[a][b]=1;
      }
      m[n/2][n/2]=4;
      printArray(m);
    }
  }
  public static void printArray(int n[][])
  {
    for(int m[]:n)
    {
      for(int o:m)
      {
        System.out.print(o);
      }
      System.out.println();
    }
    System.out.println();
  }
}