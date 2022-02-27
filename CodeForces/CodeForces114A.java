import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int k=puttingvaluesinside.nextInt();
        int l=puttingvaluesinside.nextInt();
        int count=0;
        while(l%k==0)
        {
            l/=k;
            count++;
        }
        if(l==1)
            System.out.println("YES\n"+(count-1));
        else
            System.out.println("NO");
    }
}