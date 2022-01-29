import java.util.Scanner;
public class Problem1117
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    float a=puttingvaluesinside.nextFloat();
    while(a<0||a>10)
    {
      System.out.println("nota invalida");
      a=puttingvaluesinside.nextFloat();
    }
    float b=puttingvaluesinside.nextFloat();
    while(b<0||b>10)
    {
      System.out.println("nota invalida");
      b=puttingvaluesinside.nextFloat();
    }
    System.out.printf("media = %.2f\n",(a+b)/2);
  }
}