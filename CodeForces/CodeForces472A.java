import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int arr[]=generate(1000000);
        int n=puttingvaluesinside.nextInt();
        if(n%2==0)
            System.out.println("4 "+(n-4));
        else
        {
            int a=4, b=n-a;
            while(arr[b]!=1)
            {
                a+=2;
                b-=2;
            }
            System.out.println(a+" "+b);
        }
    }
    
    public static int[] generate(int size)
    {
        int arr[]=new int[size];
        arr[0]=arr[1]=1;
        for(int i=4;i<=arr.length-1;i+=2)
        {
            arr[i]=1;
        }
        for(int i=3;i*i<=arr.length-1;i+=2)
        {
            if(arr[i]==1)
            {
                continue;
            }
            for(int j=i*i;j<=arr.length-1;j+=i*2)
            {
                arr[j]=1;
            }
        }
        return arr;
    }
}