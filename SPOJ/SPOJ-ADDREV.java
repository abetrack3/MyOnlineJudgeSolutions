import java.util.Scanner;
public class Main
{
    public static void main (String[]args)
    {
        Scanner puttingvaluesinside=new Scanner(System.in);
        int t=puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        while(t-->0)
        {
            char a[]=puttingvaluesinside.next().toCharArray(), b[]=puttingvaluesinside.next().toCharArray();
            String s1="";
            for(int i=a.length-1;i>=0;i--)
                s1+=a[i];
            String s2="";
            for(int i=b.length-1;i>=0;i--)
                s2+=b[i];
            long sum=Integer.parseInt(s1)+Integer.parseInt(s2);
            char c[]=(""+sum).toCharArray();
            String s3="";
            for(int i=c.length-1;i>=0;i--)
                s3+=(c[i]);
            System.out.println(Long.parseLong(s3));
        }
    }
}