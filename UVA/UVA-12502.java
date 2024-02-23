import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int t=puttingvaluesinside.nextInt();t>0;t--)
        {
            int a=puttingvaluesinside.nextInt(),
                b=puttingvaluesinside.nextInt(),
                c=puttingvaluesinside.nextInt();
            int s=(c*(2*a-b))/(a+b);
            if(s<0)
                System.out.println(0);
            else
                System.out.println(s);
        }
    }
}