//Problem A
//UVA 10071
import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner (System.in);
        int a=0, b=0;
        while(puttingvaluesinside.hasNextInt())
        {
            a=puttingvaluesinside.nextInt();
            b=puttingvaluesinside.nextInt();
            System.out.println(a*b*2);
        }
    }
}