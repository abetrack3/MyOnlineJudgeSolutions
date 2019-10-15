import java.util.Scanner;
public class Problem1132
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(), b=puttingvaluesinside.nextInt();
    int sum=0;
    if(a>b)
    {
      a+=b;
      b=a-b;
      a-=b;
    }
    while(a<=b)
    {
      if(a%13!=0) sum+=a;
      a++;
    }
    System.out.println(sum);
  }
}