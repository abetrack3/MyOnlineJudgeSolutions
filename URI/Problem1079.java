import java.util.Scanner;
public class Problem1079
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int c=0;c<a;c++)
      System.out.printf("%.1f\n",(puttingvaluesinside.nextFloat()*2+puttingvaluesinside.nextFloat()*3+puttingvaluesinside.nextFloat()*5)/10);
  }
}