import java.util.Scanner;
public class Problem1173
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    int b[]=new int[10];
    for(int c=0;c<b.length;c++)
      b[c]=a*(int)(Math.pow(2,c));
    int c=0;
    for(int d:b)
    {
      System.out.println("N["+c+"] = "+d);
      c++;// You forgot to increment here -,-
    }
  }
}