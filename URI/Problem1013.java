import java.util.Scanner;
public class Problem1013
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    int b=puttingvaluesinside.nextInt();
    int c=puttingvaluesinside.nextInt();
    int s;
    if(a-b>0)
    {
      s=a-b;
    }
    else
    {
      s=b-a;
    }
    int major=(a+b+s)/2;
    if(major-c>0)
    {
      s=major-c;
    }
    else
    {
      s=c-major;
    }
    major=(major+c+s)/2;
    System.out.println(major+" eh o maior");
  }
}