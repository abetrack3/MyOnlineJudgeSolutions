import java.util.Scanner;
public class Problem1012
{
  public static void main (String[]args)
  {
    Scanner pvi=new Scanner (System.in);
    double a=pvi.nextDouble();
    double b=pvi.nextDouble();
    double c=pvi.nextDouble();
    System.out.printf("TRIANGULO: %.3f\n",(a*c)/2);
    System.out.printf("CIRCULO: %.3f\n",3.14159*c*c);
    System.out.printf("TRAPEZIO: %.3f\n",((a+b)/2)*c);
    System.out.printf("QUADRADO: %.3f\n",b*b);
    System.out.printf("RETANGULO: %.3f\n",a*b);
    //Bhai!! output er spelling thik moto check korte na parle atleast copy paste koiren -,-
  }
}