import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        while(t-->0)
        {
            char []c=puttingvaluesinside.nextLine().toCharArray();
            int pos=0, sum=0;
            for(int i=0;i<c.length;i++)
                sum+=(c[i]-'a')%5;
            System.out.println(sum);
        }
    }
}