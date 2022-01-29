//Weirdly enough URI was giving wrong answers for deca=laring variables in float.
//But the code got accepted on the first try by using double as the data types.
import java.util.Scanner;
public class Problem1036
{
  public static void main (String[]args)
  {
    Scanner puttingvaluesinside=new Scanner (System.in);
//    float A,B,C;
//    A=(float)0.0000001+puttingvaluesinside.nextFloat();
//    B=(float)0.0000001+puttingvaluesinside.nextFloat();
//    C=(float)0.0000001+puttingvaluesinside.nextFloat();
    //float D=B*B-4*A*C;
    double A,B,C;
    A=puttingvaluesinside.nextDouble();
    B=puttingvaluesinside.nextDouble();
    C=puttingvaluesinside.nextDouble();
    if(A==0||((B*B-4*A*C)<0))
    {
      System.out.println("Impossivel calcular");
    }
    else
    {
      System.out.printf("R1 = %.5f\n",((-B+Math.sqrt(B*B-4*A*C))/(2*A)));
      //System.out.println("R1 = "+((-B+Math.sqrt(B*B-4*A*C))/(2*A)));
      System.out.printf("R2 = %.5f\n",((-B-Math.sqrt(B*B-4*A*C))/(2*A)));
    }
  }
}