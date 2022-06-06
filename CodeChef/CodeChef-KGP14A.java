import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int i=1;i<=t;i++)
        {
            int arr1[]=new int[puttingvaluesinside.nextInt()];
            int arr2[]=new int[arr1.length];
            for(int j=0;j<arr1.length;j++)
                arr1[j]=puttingvaluesinside.nextInt();
            for(int j=0;j<arr2.length;j++)
                arr2[j]=puttingvaluesinside.nextInt();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int sum=0;
            for(int j=0;j<arr1.length;j++)
                sum+=Math.abs(arr1[j]-arr2[j]);
            System.out.println("Case "+i+": "+sum);
        }
    }
}