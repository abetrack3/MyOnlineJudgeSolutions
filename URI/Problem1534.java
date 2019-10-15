//Do not alter this code!! Even if the program doesn't stop in IDE this is how the code got accepted at URI
import java.util.Scanner;
public class Problem1534
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int n=0;
    while(puttingvaluesinside.hasNextLine())
    {
      n=puttingvaluesinside.nextInt();
      puttingvaluesinside.nextLine();
      for(int a=0;a<n;a++)
      {
        for(int b=0;b<n;b++)
        {
          if(a+b==n-1) System.out.print(2);
          else if(a==b) System.out.print(1);
          else System.out.print(3);
        }
        System.out.println();
      }
    }
  }
}