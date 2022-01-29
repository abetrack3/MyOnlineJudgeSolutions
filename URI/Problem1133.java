import java.util.Scanner;
public class Problem1133
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt(), b=puttingvaluesinside.nextInt();
    if(a>b)
    {
      a+=b;
      b=a-b;
      a-=b;
    }
    a++;
    while(a<b)
    {
      if(a%5==2||a%5==3) System.out.println(a);
      a++;
    }
  }
}