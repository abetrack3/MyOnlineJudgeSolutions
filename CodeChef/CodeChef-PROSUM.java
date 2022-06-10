import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
//        input:1 20 58 80 97 61 71 27 7 77 89 45 48 90 74 56 31 88 22 69 91 42
//        input: 1 5 2 2 2 2 2
//        input: 1 10 1 2 3 4 5 6 7 8 9 10
//        input: 1 10 1 3 3 4 5 6 7 8 9 10
//        bruteForce();
        quichMethodUsingFormula();
    }
    
    public static void quichMethodUsingFormula()
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int b=puttingvaluesinside.nextInt();
            long c=b;
            c*=(c-1);
            c/=2;
            int arr[]=new int[3];
            while(b-->0)
            {
                int a=puttingvaluesinside.nextInt();
                if(a==1||a==0) arr[0]++;
                else if (a==2) arr[1]++;
                else arr[2]++;
            }
            long d=arr[0]+arr[1];
            d*=d-1;
            d/=2;
            c-=d;
            d=arr[0];
            d*=arr[2];
            c-=d;
            System.out.println((c<0)?0:c);
        }
        
    }
    
    public static void bruteForce()
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        while(t-->0)
        {
            long count=0;
            int arr[]=new int[puttingvaluesinside.nextInt()];
            for(int i=0;i<arr.length;i++)
                arr[i]=puttingvaluesinside.nextInt();
            for(int i=0;i<arr.length-1;i++)
            {
                for(int j=i+1;j<arr.length;j++)
                {
                    if(arr[i]*arr[j]>arr[i]+arr[j])
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}