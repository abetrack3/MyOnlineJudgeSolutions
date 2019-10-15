import java.util.Scanner;
public class Problem1099
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int b,c;a>0;a--)
    {
      b=puttingvaluesinside.nextInt();
      c=puttingvaluesinside.nextInt();
      int sum=0;
      if(b>c)
      {
        b+=c;
        c=b-c;
        b=b-c;
      }
      if(b%2==0) b++;
      else b+=2;
      while(b<c)
      {
        sum+=b;
        b+=2;
      }
      System.out.println(sum);
    }
  }
}