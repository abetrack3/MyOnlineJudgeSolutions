import java.util.Scanner;
public class Problem1065
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=0;
    for(int c=0;c<5;c++)
    {
      if(puttingvaluesinside.nextInt()%2==0)
        a++;
    }
    System.out.println(a+" valores pares");
  }
}