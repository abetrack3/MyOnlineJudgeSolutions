import java.util.Scanner;
public class Problem1075
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    if(a>2)
    {
      for(int c=2;c<=10000;c+=a)
      {
        System.out.println(c);
      }
    }
  }
}