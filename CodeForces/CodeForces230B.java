import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        int arr[]=generateSeve(1000001);
        Scanner puttingvaluesinside=new Scanner(System.in);
        for(int t=puttingvaluesinside.nextInt();t>0;t--)
        {
            long a=puttingvaluesinside.nextLong();
            int sq=(int)Math.sqrt(a);
            if(arr[sq]==0)
            {
                long b=sq;
                b*=b;
                //The previous two could have done using one line but instead the step is broken into two pieces to ensure no data loss
                if(b==a)
                {
                    System.out.println("YES");
                    continue;
                }
            }
            System.out.println("NO");
        }
    }
    
    public static int[] generateSeve(int size)
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