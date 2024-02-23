//Problem K
//URI - 1436
//UVA - 11875
import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int a=1;a<=t;a++)
        {
            int [] arr=new int[puttingvaluesinside.nextInt()];
            for(int b=0;b<arr.length;b++)
                arr[b]=puttingvaluesinside.nextInt();
            Arrays.sort(arr);
            System.out.println("Case "+a+": "+arr[arr.length/2]);
        }
    }
}