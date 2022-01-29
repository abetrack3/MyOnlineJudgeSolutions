import java.util.Scanner;
public class Problem1134
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner(System.in);
    int a=0,b=0,c=0, d=puttingvaluesinside.nextInt();
    while(d!=4)
    {
      switch (d)
      {
        case 1: a++; break;
        case 2: b++; break;
        case 3: c++; break;
      }
      d=puttingvaluesinside.nextInt();
    }
    System.out.println("MUITO OBRIGADO\nAlcool: "+a+"\nGasolina: "+b+"\nDiesel: "+c);
  }
}