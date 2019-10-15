import java.util.Scanner;
public class Problem1177
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(),d=0;
    int b[]=new int[1000];
    for(int c=0;c<b.length;c++)
    {
      if(d<a==false) d=0;
      b[c]=d;
      d++;
    }
    for(int c=0;c<b.length;c++) System.out.println("N["+c+"] = "+b[c]);
  }
}