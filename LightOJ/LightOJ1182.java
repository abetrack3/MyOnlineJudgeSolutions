import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int b=1;b<=t;b++)
        {
            long a=puttingvaluesinside.nextLong();
            long count=0;
            while(a!=0)
            {
                if(a%2==1)
                    count++;
                a/=2;
            }
            if(count%2==0)
                System.out.println("Case "+b+": even");
            else
                System.out.println("Case "+b+": odd");
        }
    }
}