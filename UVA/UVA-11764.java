import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        for(int c=1;c<=t;c++)
        {
            int [] arr=new int[puttingvaluesinside.nextInt()];
            for(int n=0;n<arr.length;n++)
                arr[n]=puttingvaluesinside.nextInt();
            int highCount=0, lowCount=0;
            for(int n=0;n<arr.length-1;n++)
            {
                if(arr[n]<arr[n+1]) highCount++;
                else if(arr[n]>arr[n+1]) lowCount++;
            }
            System.out.println("Case "+c+": "+highCount+" "+lowCount);
        }
    }
}