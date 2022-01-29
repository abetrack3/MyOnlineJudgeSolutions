import java.util.Scanner;
public class Problem1046
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int
      a=puttingvaluesinside.nextInt(),
      b=puttingvaluesinside.nextInt();
    if(a==b)
    {
      System.out.println("O JOGO DUROU 24 HORA(S)");
    }
    else if(a>b)
    {
      System.out.println("O JOGO DUROU "+(24+b-a)+" HORA(S)");
    }
    else if(a<b)
    {
      System.out.println("O JOGO DUROU "+(b-a)+" HORA(S)");
    }
  }
}