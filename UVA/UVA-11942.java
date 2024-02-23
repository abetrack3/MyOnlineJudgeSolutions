import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int arr[][]=new int[puttingvaluesinside.nextInt()][10];
        for(int n=0;n<arr.length;n++)
        {
            for(int m=0;m<arr[n].length;m++)
                arr[n][m]=puttingvaluesinside.nextInt();
        }
        System.out.println("Lumberjacks:");
        
        for(int n=0;n<arr.length;n++)
        {
            boolean descendingOrder=true, ascendingOrder=true;
            for(int m=0;m<arr[n].length-1;m++)
            {
                if(ascendingOrder==false&&descendingOrder==false)
                    break;
                if(arr[n][m]>arr[n][m+1])
                {
                    if(ascendingOrder) ascendingOrder=false;
                }
                if(arr[n][m]<arr[n][m+1])
                {
                    if(descendingOrder) descendingOrder=false;
                }
            }
            if(ascendingOrder^descendingOrder)
                System.out.println("Ordered");
            else
                System.out.println("Unordered");
        }
    }
}