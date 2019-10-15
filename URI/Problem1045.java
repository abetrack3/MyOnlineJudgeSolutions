//import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
public class Problem1045
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
    double a[]=
    {
      puttingvaluesinside.nextDouble(),
      puttingvaluesinside.nextDouble(),
      puttingvaluesinside.nextDouble()
    };
    Arrays.sort(a);
    //Arrays.sort(a,Collections.reverseOrder());
    //System.out.println(a[1]+" "+a[2]+" "+(a[1]==a[2]));
    if(a[2]>=(a[1]+a[0]))
    {
      System.out.println("NAO FORMA TRIANGULO");
    }
    else
    {
      if(a[2]*a[2]==(a[1]*a[1]+a[0]*a[0]))
      {
        System.out.println("TRIANGULO RETANGULO");
      }
      if(a[2]*a[2]>(a[1]*a[1]+a[0]*a[0]))
      {
        System.out.println("TRIANGULO OBTUSANGULO");
      }
      if(a[2]*a[2]<(a[1]*a[1]+a[0]*a[0]))
      {
        System.out.println("TRIANGULO ACUTANGULO");
      }
      if(a[2]==a[1]&&a[2]==a[0])
      {
        System.out.println("TRIANGULO EQUILATERO");
      }
      else if(a[2]==a[1]||a[2]==a[0]||a[1]==a[0])
      {
        System.out.println("TRIANGULO ISOSCELES");
      }
    }
  }
}