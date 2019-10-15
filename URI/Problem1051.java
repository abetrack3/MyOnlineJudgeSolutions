import java.util.Scanner;
public class Problem1051
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    float a=puttingvaluesinside.nextFloat();
    if(a<=2000)
    {
      System.out.println("Isento");
    }
    else if(a<=3000)
    {
      System.out.printf("R$ %.2f\n",(a-2000)*0.08);
    }
    else if(a<=4500)
    {
      System.out.printf("R$ %.2f\n",(a-3000)*0.18+80);
    }
    else
    {
      System.out.printf("R$ %.2f\n",(a-4500)*0.28+80+270);
    }
  }
}