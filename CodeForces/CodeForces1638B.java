import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        int test = Integer.parseInt(reader.readLine());
 
        while (test --> 0) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine());
            boolean flag = true;
            int odd = 1, even = 2;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 0 && num >= even)
                    even = num;
                else if(num % 2 == 1 && num >= odd)
                    odd = num;
                else {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("YES");
        }
 
    }
}