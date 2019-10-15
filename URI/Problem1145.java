import java.util.Scanner;
public class Problem1145
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int x=puttingvaluesinside.nextInt(), y=puttingvaluesinside.nextInt();
    for(int a=1;a<=y;a++)
    {
      System.out.print(a);
      if(a%x!=0) System.out.print(" ");
      //if(a%(x)==0) 
      else System.out.println();
    }
    if(y%x!=0) System.out.println();
  }
}