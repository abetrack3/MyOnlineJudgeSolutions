import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int i=1;i<=t;i++)
        {
            int a=puttingvaluesinside.nextInt();
            int b=puttingvaluesinside.nextInt();
            int sum=5+5+9+4*a+Math.abs(a-b)*4;
            System.out.println("Case "+i+": "+sum);
        }
    }
}