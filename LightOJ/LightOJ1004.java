import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
public class ProblemI 
{
    public static BufferedReader br;
    public static StringTokenizer st;
    public static long arr1[] = new long[100];
    public static long arr2[] = new long[100];

    public static void main(String[] args) throws Exception
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        int test = Integer.parseInt(next());
        for(int i = test; i --> 0;)
            out.write(String.format("Case %d: %d\n", test - i, solve()));
        out.flush();
        out.close(); 
    }

    public static long solve() throws Exception
    {
        int n = Integer.parseInt(next());
        arr1[0] = Long.parseLong(next());
        for(int i = 1; i < n; i++)
        {
            arr2[0] = Long.parseLong(next()) + arr1[0];
            for(int j = 1; j < i; j++)
                arr2[j] = Long.parseLong(next()) + Math.max(arr1[j], arr1[j - 1]);
            arr2[i] = Long.parseLong(next()) + arr1[i - 1];
            swap();
        }
        for(int i = n - 1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
                arr2[j] = Long.parseLong(next()) + Math.max(arr1[j], arr1[j + 1]);
            swap();
        }
        long ans = arr1[0];
        java.util.Arrays.fill(arr1, 0);
        java.util.Arrays.fill(arr2, 0);
        return ans;
    }

    public static void swap()
    {
        long temp[] = arr1;
        arr1 = arr2;
        arr2 = temp;

    }

    public static String next() throws Exception
    {
        if(!st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

}
