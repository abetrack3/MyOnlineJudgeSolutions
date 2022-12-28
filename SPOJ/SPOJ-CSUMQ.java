import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main (String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int [] arr=new int[sc.nextInt()];
        arr[0]=sc.nextInt();
        for(int a=1;a<arr.length;a++)
        {
            arr[a]=arr[a-1]+sc.nextInt();
        }
        for(int a=sc.nextInt();a>0;a--)
        {
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(b==0)
                System.out.println(arr[c]);
            else
                System.out.println(arr[c]-arr[b-1]);
        }
    }
}