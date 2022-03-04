import java.util.Scanner;
public class CodeForces1143A
{
    public static void main (String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int a=0, b=0, n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            int c=sc.nextInt();
            if(c==0) a=i;
            else if(c==1) b=i;
        }
        System.out.println((a<b)?a:b);
    }
}
