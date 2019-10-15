import java.util.Scanner;
public class Problem1175
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a[]=new int[20];
    for(int c=a.length-1;c>=0;c--) a[c]=puttingvaluesinside.nextInt();
    for(int c=0;c<a.length;c++) System.out.println("N["+c+"] = "+a[c]);
  }
}