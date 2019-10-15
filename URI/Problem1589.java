import java.util.Scanner;
public class Problem1589
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    for(int a=puttingvaluesinside.nextInt();a>0;a--)
      System.out.println(puttingvaluesinside.nextInt()+puttingvaluesinside.nextInt());
  }
}