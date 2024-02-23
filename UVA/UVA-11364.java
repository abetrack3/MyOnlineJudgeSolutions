//Problem H
//UVA 11364
import java.util.Scanner;
public class Main
{
    public static void main (String [] args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int t=puttingvaluesinside.nextInt();t>0;t--)
        {
            int s=puttingvaluesinside.nextInt();
            int min, max;
            min=max=puttingvaluesinside.nextInt();
            for(;s>1;s--)
            {
                int x=puttingvaluesinside.nextInt();
                if(x>max) max=x;
                else if(x<min) min=x;
            }
            System.out.println((max-min)*2);
        }
    }
}