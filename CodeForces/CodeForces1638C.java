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
            int comp = 1, max = Integer.parseInt(st.nextToken());
            for(int i = 2; i <= n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    if(i > max) {    
                        comp++;
                    }
                    max = num;
                }
            }
            System.out.println(comp);
        }      
    }
}