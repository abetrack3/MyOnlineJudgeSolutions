import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int arr[]=new int[3];
        for(int i=puttingvaluesinside.nextInt(), j=0;i>0;i--, j=(j+1)%arr.length)
        {
            arr[j]+=puttingvaluesinside.nextInt();
        }
        int max=(int)Math.max(arr[0], Math.max(arr[1], arr[2]));
        if(arr[0]==max)
            System.out.println("chest");
        else if(arr[1]==max)
            System.out.println("biceps");
        else
            System.out.println("back");
    }
}