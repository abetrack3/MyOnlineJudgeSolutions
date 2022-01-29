import java.util.Scanner;
public class Problem1164
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int sum=1, test=0;
    for(int a=puttingvaluesinside.nextInt();a>0;a--)
    {
      sum=1; test=puttingvaluesinside.nextInt();
      if(test==1) {System.out.println("1 nao eh perfeito"); continue;}
      for(int b=2;b<test;b++)
      {
        if(test%b==0)
        {
          sum+=b;
        }
      }
      if(sum==test) System.out.println(test+" eh perfeito");
      else System.out.println(test+" nao eh perfeito");
    }
  }
}