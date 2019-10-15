//import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Problem1178d
{
  public static void main (String[]args) throws IOException
  {
//    Scanner puttingvaluesinside=new Scanner (System.in);
    BufferedReader puttingvaluesinside=new BufferedReader(new InputStreamReader(System.in));
    double a=Double.parseDouble(puttingvaluesinside.readLine()), b=0;
    System.out.printf("%.4f\n",a);
    for(int c=0;c<100;c++)
    {
      b=a/Math.pow(2,c);
      //b*=100000;
      if((100000*b)%10==5) b=((100000*b)-1)/100000; //Don't know to what extent it works but this is the key code //Cheat code actually //Doesn't work for actual large input value
      //b/=100000;
      //System.out.printf("N[%d] = %.4f\n",c,b);
    }
  }
}