import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int a=puttingvaluesinside.nextInt(), b=puttingvaluesinside.nextInt();
        int fCase=1;
        while(!(a==0||b==0))
        {
            puttingvaluesinside.nextLine();
            int arr[][]=new int[a][b];
            for(int c=0;c<a;c++)
            {
                char [] d=puttingvaluesinside.nextLine().toCharArray();
                for(int e=0;e<d.length;e++)
                {
                    if(d[e]=='*')
                    {
                        adjacentAlert(arr, c, e);
                    }
                }
            }
            fPrint(fCase, arr);
            
            a=puttingvaluesinside.nextInt();
            b=puttingvaluesinside.nextInt();
            if(!(a==0||b==0))
                System.out.println();
            fCase++;
        }
    }
    private static void adjacentAlert(int arr[][], int a, int b)
    {
        try
        {
            arr[a][b]=-1;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a-1][b-1]==-1))
                arr[a-1][b-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a-1][b]==-1))
                arr[a-1][b]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a-1][b+1]==-1))
                arr[a-1][b+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a][b-1]==-1))
                arr[a][b-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a][b+1]==-1))
                arr[a][b+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a+1][b-1]==-1))
                arr[a+1][b-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a+1][b]==-1))
                arr[a+1][b]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try
        {
            if(!(arr[a+1][b+1]==-1))
                   arr[a+1][b+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
    private static void fPrint(int fCase, int arr[][])
    {
        System.out.println("Field #"+fCase+":");
        for(int a=0;a<arr.length;a++)
        {
            for(int b=0;b<arr[a].length;b++)
            {
                if(arr[a][b]==-1)
                    System.out.print("*");
                else
                    System.out.print(arr[a][b]);
            }
            System.out.println();
        }
//        System.out.println();
    }
}