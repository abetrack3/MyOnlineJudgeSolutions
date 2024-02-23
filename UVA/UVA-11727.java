import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int a=puttingvaluesinside.nextInt(), b=1;a>0;a--, b++)
        {
            int arr[]=
            {
                puttingvaluesinside.nextInt(),
                puttingvaluesinside.nextInt(),
                puttingvaluesinside.nextInt()
            };
            Arrays.sort(arr);
            System.out.println("Case "+b+": "+arr[1]);
        }
    }
}