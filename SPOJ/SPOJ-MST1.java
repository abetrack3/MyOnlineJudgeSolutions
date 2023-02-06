import java.util.Scanner;
public class Main {

    public static int cache[] = new int[(int)2e7 + 1];

    public static void main(String[] args) 
    {
        buildCache();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++)
        {
            System.out.printf("Case %d: %d\n", i, cache[scanner.nextInt()]);
        }
    }

    public static void buildCache() 
    {
        // java.util.Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = cache[2] = cache[3] = 1;
        cache[1] = 0;
        for(int i= 4; i < cache.length; i++)
        {
            cache[i] = 1 + cache[i - 1];
            if(i % 2 == 0)
                cache[i] = Math.min(cache[i], 1 + cache[i / 2]);
            if(i % 3 == 0)
                cache[i] = Math.min(cache[i], 1 + cache[i / 3]);
        }
    }

}
