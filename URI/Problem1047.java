import java.util.Scanner;
public class Problem1047
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    int a=puttingvaluesinside.nextInt()*60+puttingvaluesinside.nextInt();
    int b=puttingvaluesinside.nextInt()*60+puttingvaluesinside.nextInt();
    if(a==b)
    {
      System.out.println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)");
    }
    else if(a>b)
    {
      System.out.println("O JOGO DUROU "+((1440+b-a)/60)+" HORA(S) E "+((1440+b-a)%60)+" MINUTO(S)");
    }
    else if(b>a)
    {
      System.out.println("O JOGO DUROU "+((b-a)/60)+" HORA(S) E "+((b-a)%60)+" MINUTO(S)");
    }
  }
}