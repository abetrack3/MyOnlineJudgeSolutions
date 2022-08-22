import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int t=puttingvaluesinside.nextInt();t>0;t--)
        {
            int a=puttingvaluesinside.nextInt();
            if(a>10)
                System.out.println(10+" "+(a-10));
            else
                System.out.println(a+" "+0);
        }
    }
}