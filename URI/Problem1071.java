import java.util.Scanner;
public class Problem1071
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    int b=puttingvaluesinside.nextInt();
    //System.out.println(a+" "+b);
    if(a>b)
    {
      a=a+b;
      b=a-b;
      a=a-b;
    }
    //System.out.println(a+" "+b);
    int sum=0;
    if(a%2==0) a++;
    else a+=2;
    for(int c=a;c<b;c+=2)
      sum+=c;
    System.out.println(sum);
  }
}