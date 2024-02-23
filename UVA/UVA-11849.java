import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main
{
    public static void main (String [] abc) throws IOException
    {
        BufferedReader puttingvaluesinside=new BufferedReader(new InputStreamReader(System.in));
        String s=puttingvaluesinside.readLine();
        while (!s.equals("0 0"))
        {
            StringTokenizer st=new StringTokenizer(s);
            int M=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());
            HashSet<String> cdSet=new HashSet<>();
            for (int i=0;i<M;i++)
                cdSet.add(puttingvaluesinside.readLine());
            int count=0;
            for (int i=0;i<N;i++)
            {
                if (cdSet.contains(puttingvaluesinside.readLine()))
                    count++;
            }
            
            System.out.println(count);
            s=puttingvaluesinside.readLine();
        }
    }
}