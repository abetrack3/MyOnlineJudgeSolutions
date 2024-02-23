import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int t=puttingvaluesinside.nextInt();t>0;t--)
        {
            int [] n=new int [puttingvaluesinside.nextInt()];
            int sum=0;
            for(int i=0;i<n.length;i++)
            {
                n[i]=puttingvaluesinside.nextInt();
                sum+=n[i];
            }
            sum/=n.length;
            int count=0;
            for(int x:n)
            {
                if(x>sum)
                    count++;
            }
            System.out.printf("%.3f%%%n",(100.00*count)/n.length);
        }
    }
}