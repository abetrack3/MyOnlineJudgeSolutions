import java.util.Scanner;
public class Problem1149
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(), sum=a, b=puttingvaluesinside.nextInt();
    while(b<1) b=puttingvaluesinside.nextInt();
    for(int c=1;c<b;c++)
      sum+=a+c;
    System.out.println(sum);
  }
}