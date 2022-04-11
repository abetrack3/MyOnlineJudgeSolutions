import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[91];
        for(int i=sc.nextInt();i>0;i--)
            arr[sc.nextInt()]++;
        int timer=15;
        int i;
        for(i=1;i<arr.length;i++)
        {
            if(timer==0)
                break;
            if(arr[i]==1)
                timer=15;
            else
                timer--;
        }
        System.out.println(i-1);
    }
}