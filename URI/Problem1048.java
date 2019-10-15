import java.util.Scanner;
public class Problem1048
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double a=puttingvaluesinside.nextDouble();
    if(a<=400)
    {
      System.out.printf("Novo salario: %.2f\n",a*1.15);
      System.out.printf("Reajuste ganho: %.2f\n",a*0.15);
      System.out.printf("Em percentual: 15 %%\n");
    }
    else if(a<=800)
    {
      System.out.printf("Novo salario: %.2f\n",a*1.12);
      System.out.printf("Reajuste ganho: %.2f\n",a*0.12);
      System.out.printf("Em percentual: 12 %%\n");
    }
    else if(a<=1200)
    {
      System.out.printf("Novo salario: %.2f\n",a*1.10);
      System.out.printf("Reajuste ganho: %.2f\n",a*0.10);
      System.out.printf("Em percentual: 10 %%\n");
    }
    else if(a<=2000)
    {
      System.out.printf("Novo salario: %.2f\n",a*1.07);
      System.out.printf("Reajuste ganho: %.2f\n",a*0.07);
      System.out.printf("Em percentual: 7 %%\n");
    }
    else
    {
      System.out.printf("Novo salario: %.2f\n",a*1.04);
      System.out.printf("Reajuste ganho: %.2f\n",a*0.04);
      System.out.printf("Em percentual: 4 %%\n");
    }
  }
}