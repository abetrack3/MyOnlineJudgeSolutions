import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main(String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        int arr[]=new int[26];
        while(t-->0)
        {
            Arrays.fill(arr, 0);
            char [] c=puttingvaluesinside.nextLine().toCharArray();
            for(char x:c)
                arr[x-'a']++;
            Arrays.sort(arr);
            System.out.println((2*arr[arr.length-1]==c.length)?"YES":"NO");
        }
    }
}