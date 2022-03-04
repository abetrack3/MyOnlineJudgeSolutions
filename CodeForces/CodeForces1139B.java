import java.util.Scanner;
public class CodeForces1139B
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        int arr[] = new int[t];
        while(t-->0)
            arr[t] = puttingvaluesinside.nextInt();
        long sum = arr[0];
        int prev = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if((prev-1)==0)
                break;
            prev = ((prev-1)<arr[i])? prev-1 : arr[i];
            sum+=prev;
        }
        System.out.println(sum);
    }
}
