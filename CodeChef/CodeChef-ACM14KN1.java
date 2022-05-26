import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        myApproach();
    }
    
    public static void usingAlgoFromTheProblemEditorial()
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        while(t-->0)
        {
            long start=puttingvaluesinside.nextLong(), end=puttingvaluesinside.nextLong();
            int t2=puttingvaluesinside.nextInt();
            boolean flag=true;
            while(t2-->0)
            {
                long a=puttingvaluesinside.nextLong(), b=puttingvaluesinside.nextLong();
                if(flag)
                {
                    if(Math.max(start, a)<Math.min(end, b))
                        flag=false;
                }
            }
            System.out.println((flag)?"YES":"NO");
        }
    }
    
    public static void myApproach ()
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        while(t-->0)
        {
            long start=puttingvaluesinside.nextLong(), end=puttingvaluesinside.nextLong();
//            BigInteger start=puttingvaluesinside.nextBigInteger(), end=puttingvaluesinside.nextBigInteger();
            int t2=puttingvaluesinside.nextInt();
            boolean flag=true;
            while(t2-->0)
            {
                long a=puttingvaluesinside.nextLong(), b=puttingvaluesinside.nextLong();
                if((a>start && a<end) || (b>start && b<end))
                    flag = false;
                if(a<=start&&end<=b)
                    flag=false;
//                if(flag)
//                {
//                    if((a<=start)&&(b>=end))
//                        flag=false;
//                    else if((a>=start)&&(a<end))
//                        flag=false;
//                    else if((b<=end)&&(b>start))
//                        flag=false;
//                }
            }
            System.out.println((flag)?"YES":"NO");
        }
    }
}