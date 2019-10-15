import java.util.Scanner;
public class Problem1541
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=0, b=0, c=0;
    while(true)
    {
      a=puttingvaluesinside.nextInt(); if(a==0) break;
      b=puttingvaluesinside.nextInt(); if(b==0) break;
      c=puttingvaluesinside.nextInt(); if(c==0) break;
      float d=(float)Math.sqrt(a*b*100.00/c);
      System.out.println((int)d);
    }
  }
}