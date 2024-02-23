//Problem J
//UVA - 12578
import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int a=puttingvaluesinside.nextInt();a>0;a--)
        {
            int l=puttingvaluesinside.nextInt();
            System.out.printf("%.2f %.2f\n",l*l*Math.PI/25.0,l*l*3.0/5.0-l*l*Math.PI/25.0);
        }
    }
}