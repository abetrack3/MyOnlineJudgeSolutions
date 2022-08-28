import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int i=1;i<=t;i++)
        {
            double a=puttingvaluesinside.nextDouble();
            double area=a*a*(4-Math.PI);
            System.out.printf("Case %d: %.2f\n",i,area);
        }
    }
}