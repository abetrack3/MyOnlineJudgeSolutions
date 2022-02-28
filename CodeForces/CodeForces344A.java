import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main
{
    public static void main (String[]args) throws IOException
    {
        BufferedReader puttingvaluesinside=new BufferedReader(new InputStreamReader(System.in));
        int count=1;
        for(int i=Integer.parseInt(puttingvaluesinside.readLine())-1, a=Integer.parseInt(puttingvaluesinside.readLine());i>0;i--)
        {
            int b=Integer.parseInt(puttingvaluesinside.readLine());
            if(a!=b)
            {
                count++;
                a=b;
            }
        }
        System.out.println(count);
    }
}