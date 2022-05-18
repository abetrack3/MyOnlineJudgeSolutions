import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int t=puttingvaluesinside.nextInt();t>0;t--)
        {
            long j=puttingvaluesinside.nextLong();
//            long j=t;
//            int brute=bruteForce(j);
            int half=halfApproach(j);
            System.out.println(half);
//            if(half!=brute)
//            {
//                System.out.println(j+" "+brute+" "+half);
//                System.err.println(false);
//                break;
//            }
        }
    }
    
    public static int bruteForce(long j)
    {
        int count=0;
        for(long a=1;a<=j;a++)
        {
            if(j%a==0&&a%2==0)
                count++;
        }
        return (count);
    }
    
    public static int halfApproach(long j)
    {
        int count=0;
        for(int a=1;a*a<=j;a++)
        {
            if(j%a==0)
            {
                if(a%2==0)
                    count++;
                if(j/a%2==0&&j/a!=a)
                    count++;
            }
        }
        return (count);
    }
}