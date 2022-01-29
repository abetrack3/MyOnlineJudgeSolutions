import java.util.Scanner;
public class Problem1150
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(), b=puttingvaluesinside.nextInt(), sum=a, d=1;
    while(b<=a) b=puttingvaluesinside.nextInt();
    //The condition here is important!! Never would have found out without using debugger! :)
    while(sum<=b)
    {
      sum+=a+d;
      d++;
    }
    System.out.println(d);
  }
}