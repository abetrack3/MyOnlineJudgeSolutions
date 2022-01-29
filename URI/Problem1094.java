import java.util.Scanner;
public class Problem1094
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    int b=0,c=0,d=0;
    for(int e=0,f=0;e<a;e++)
    {
      f=puttingvaluesinside.nextInt();
      switch (puttingvaluesinside.next())
      {
        case "C": b+=f; break;
        case "R": c+=f; break;
        case "S": d+=f; break;
      }
    }
    System.out.println("Total: "+(b+c+d)+" cobaias\n"+"Total de coelhos: "+b+"\nTotal de ratos: "+c+"\nTotal de sapos: "+d);
    System.out.printf("Percentual de coelhos: %.2f %%\nPercentual de ratos: %.2f %%\nPercentual de sapos: %.2f %%\n",(100.00*b)/(b+c+d),(100.00*c)/(b+c+d),(100.00*d)/(b+c+d));
  }
}