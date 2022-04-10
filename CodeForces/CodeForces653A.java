import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int arr[]=new int[1000];
        for(int i=puttingvaluesinside.nextInt();i>0;i--)
            arr[puttingvaluesinside.nextInt()-1]++;
        for(int i=2;i<arr.length;i++)
        {
            if((arr[i]>0)&&(arr[i-1]>0)&&(arr[i-2]>0))
            {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}