import java.util.Arrays;
import java.util.Scanner;
public class Problem1042
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a[]=
    {
      puttingvaluesinside.nextInt(),
      puttingvaluesinside.nextInt(),
      puttingvaluesinside.nextInt()
    };
    int b[]=a.clone();
    Arrays.sort(b);
    for(int x:b)
      System.out.println(x);
    System.out.println();
    for(int x:a)
      System.out.println(x);
  }
}