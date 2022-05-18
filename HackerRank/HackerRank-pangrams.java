import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int [] arr=new int[26];
        int count=0;
        char [] c=puttingvaluesinside.nextLine().toCharArray();
        for(int a=0;a<c.length;a++)
        {
            if(c[a]==' ') continue;
            if(c[a]>96)
            {
                if(arr[c[a]%97]==0)
                {
                    arr[c[a]%97]++;
                    count++;
                }
            }
            else
            {
                if(arr[c[a]%65]==0)
                {
                    arr[c[a]%65]++;
                    count++;
                }
            }
            if(count==26)
            {
                System.out.println("pangram");
                return;
            }
        }
        System.out.println("not pangram");
    }
}