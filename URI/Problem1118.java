import java.util.Scanner;
public class Problem1118
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    boolean flag=true;
    while(flag)
    {
    float a=puttingvaluesinside.nextFloat();
      while(a<0||a>10)
      {
        System.out.println("nota invalida");
        a=puttingvaluesinside.nextFloat();
      }
      float b=puttingvaluesinside.nextFloat();
      while(b<0||b>10)
      {
        System.out.println("nota invalida");
        b=puttingvaluesinside.nextFloat();
      }
      System.out.printf("media = %.2f\n",(a+b)/2);
      int c;
      do
      {
        System.out.println("novo calculo (1-sim 2-nao)");
        c=puttingvaluesinside.nextInt();
        if(c==1) flag=true;
        else if(c==2) flag=false;
      }while(c>2||c<1);
    }
  }
}