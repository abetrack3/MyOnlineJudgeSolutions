import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int n=0;
        while((n=puttingvaluesinside.nextInt())!=0)
        {
            int s=0;
            for(int a=1;a<=n;a++)
                s+=a*a;
            System.out.println(s);
        }
    }
}