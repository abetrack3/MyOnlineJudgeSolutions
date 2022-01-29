import java.util.Scanner;
public class Problem1165
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int b=0,c=0;
    for(int a=puttingvaluesinside.nextInt();a>0;a--)
    {
      b=puttingvaluesinside.nextInt(); c=0;
      if(b==0||b==1) {System.out.println(b+" nao eh primo"); continue;}
      for(int d=2;d<b;d++) if(b%d==0) {c++; break;}
      if(c==0) System.out.println(b+" eh primo");
      else System.out.println(b+" nao eh primo");
    }
  }
}