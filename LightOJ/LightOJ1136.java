import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(long i=1;i<=t;i++)
        {
            long a=puttingvaluesinside.nextLong();
            long b=puttingvaluesinside.nextLong();
            long count=((b-a+1)/3)*2;
            a+=((b-a+1)/3)*3;
            for(long j=a;j<=b;j++)
            {
                if(j%3!=1)
                    count++;
            }
            System.out.printf("Case %d: %d\n",i,count);
        }
    }
}