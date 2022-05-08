import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n=puttingvaluesinside.nextInt();
            System.out.println(n*(n-1)/2);
        }
    }
}