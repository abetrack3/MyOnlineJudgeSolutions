import java.util.HashMap;
import java.util.Scanner;

public class CodeForces1642C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long test = scanner.nextLong();
        while (test --> 0) {
            long n = scanner.nextLong(), x = scanner.nextLong();
            HashMap<Long, Long> map = new HashMap<Long, Long>();
            for (long i = 0; i < n; i++) {
                long temp = scanner.nextLong();
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp)+1);
                } else { map.put(temp,(long)1); }
            }
            Long[] array = new Long[map.size()];
            map.keySet().toArray(array);
            java.util.Arrays.sort(array);
            for (Long Long : array) {
                if (map.containsKey(Long * x) && map.containsKey(Long)) {
                    long long1 = map.get(Long);
                    long long2 = map.get(Long*x);
                    long min = Math.min(long1, long2);
                    long1 -= min;
                    long2 -= min;
                    if (long1 == 0) map.remove(Long);
                    else map.put(Long, long1);
                    if (long2 == 0) map.remove(Long*x);
                    else map.put(Long*x, long2);
                }
            }
            long sum = 0;
            for(long key : map.keySet())
                sum += map.get(key);
            System.out.println(sum);
        }
    }
}
