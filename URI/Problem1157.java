import java.util.Scanner;
public class Problem1157
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    for(int c=1;c<=a;c++)
      if(a%c==0) System.out.println(c);
  }
}