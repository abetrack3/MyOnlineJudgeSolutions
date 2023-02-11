import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int i=1;i<=t;i++)
        {
            long n=puttingvaluesinside.nextLong();
            boolean flag=squareRootApproach(n);
            System.out.println("Case "+i+": "+((flag)?"Yes":"No"));
        }
    }
    
    public static boolean squareRootApproach(long n)
    {
        long k=(long)Math.sqrt(n);
        k*=k;
        return k==n;
    }
    
    public static boolean bruteForce(long n)
    {
        long count=0;
        for(long i=1;i<=n;i++)
        {
            if(n%i==0)
                count++;
        }
        return !(count%2==0);
    }
}