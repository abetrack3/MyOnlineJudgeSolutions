//Problem I
//UVA - 12468
import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        while(true)
        {
            int a=puttingvaluesinside.nextInt(),
                b=puttingvaluesinside.nextInt();
            if(a==-1||b==-1) break;
            int d=b-a;
            d=(d<0)?-d:d;
            if(100-d<d) d=100-d;
            System.out.println(d);
        }
    }
}