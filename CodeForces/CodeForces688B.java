import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main
{
    public static void main (String[]args) throws IOException
    {
        BufferedReader puttingvaluesinside=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        sb.append(puttingvaluesinside.readLine());
        System.out.print(sb);
        System.out.println(sb.reverse());
    }
}