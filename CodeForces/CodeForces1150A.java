import java.util.Scanner;
public class CodeForces1150A
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int b=puttingvaluesinside.nextInt();
        int s=puttingvaluesinside.nextInt();
        int amount=puttingvaluesinside.nextInt();
        int min=puttingvaluesinside.nextInt();
        for(int i=1;i<b;i++)
        {
            int temp=puttingvaluesinside.nextInt();
            if(temp<min)
                min=temp;
        }
        int max=puttingvaluesinside.nextInt();
        for(int i=1;i<s;i++)
        {
            int temp=puttingvaluesinside.nextInt();
            if(temp>max)
                max=temp;
        }
        if(min>max)
            System.out.println(amount);
        else
            System.out.println(amount%min+amount/min*max);
    }
}
