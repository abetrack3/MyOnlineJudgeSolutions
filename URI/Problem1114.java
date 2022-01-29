import java.util.Scanner;
public class Problem1114
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    int a=puttingvaluesinside.nextInt();
    while(a!=2002)
    {
      System.out.println("Senha Invalida");
      a=puttingvaluesinside.nextInt();
    }
    System.out.println("Acesso Permitido");
  }
}