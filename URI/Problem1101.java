import java.util.Scanner;
public class Problem1101
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    int b=puttingvaluesinside.nextInt();
    int sum=0;
    while(a>0&&b>0)
    {
      if(a>b)
      {
        a+=b;
        b=a-b;
        a-=b;
      }
      sum=0;
      while(a<=b)
      {
        System.out.print(a+" ");
        sum+=a;
        a++;
      }
      System.out.println("Sum="+sum);
      a=puttingvaluesinside.nextInt();
      b=puttingvaluesinside.nextInt();
    }
  }
}