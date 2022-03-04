import java.util.Scanner;
class CodeForces1141E {
    public static void main(String[] args) {
        
        run();
        // autoTesting();

    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        long hp = scanner.nextLong();
        long n = scanner.nextLong();

        long sum = 0;
        long[] arr = new long[(int)n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
            if (hp + sum <= 0) {
                System.out.println(i + 1);
                return;
            }
        }
        if (sum >= 0) { System.out.println(-1); return; }
        System.out.println(solve2(hp, arr));
        // System.out.println(bruteForce(hp, arr));

        scanner.close();
    }

    public static long solve2(long hp, long[] arr) {
        long contagiousMin = 0, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            contagiousMin = Math.min(contagiousMin, sum);
        }
        long x = (hp + contagiousMin) / Math.abs(sum);
        sum *= x;
        long ans = x * arr.length;
        int index = 0;
        while (hp + sum > 0) {
            ans++;
            sum += arr[index++];
            index %= arr.length;
        }
        return ans;
    }

    public static long solve(long hp, long[] arr) {
        for (int i = 1; i < arr.length; i++) { arr[i] += arr[i - 1]; }
        long sum = arr[arr.length - 1];
        long ans = Math.max(1, (hp + arr[0]) / Math.abs(sum)) * arr.length + 1;

        for (int i = 0; i < arr.length; i++) {
            long x = (hp + arr[i]) / Math.abs(sum);
            if (hp + Math.max(1, x) * sum + arr[i] <= 0) {
                while (hp + Math.max(1, x) * sum + arr[i] <= 0 && x >= 0) {
                    ans = Math.min(ans, Math.max(1, x) * arr.length + i + 1);
                    x--;
                }
            }
        }
        return ans;
    }

    public static long bruteForce(long hp, long[] arr) {
        long ans = 0;
        long sumHP = 0;
        int index = 0;
        while (hp + sumHP > 0) {
            ans++;
            sumHP += arr[index++];
            index %= arr.length;
        }
        return ans;
    }

    public static void autoTesting() {
        int count = 1;
        while (true) {
            long hp = (long)(Math.random() * 1E12);
            long[] arr = generateArray(5);
            long[] arr2 = arr.clone();
            if (firsRound(hp, arr)) continue;
            long bruteForce = bruteForce(hp, arr);
            long solve = solve2(hp, arr2);
            if( bruteForce != solve ) {
                System.out.println(bruteForce);
                System.out.println(solve);
                System.out.println(hp + " " + arr.length);
                System.out.println(toArrayString(arr));
                break;
            }
            System.out.println(count);
            count++;
        }
        
    }

    public static String toArrayString(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (long l : arr) {
            if(sb.length() != 0) sb.append(" ");
            sb.append(l);
        }
        return sb.toString();
    }

    public static boolean firsRound(long hp, long[] arr) {
        long sum = 0;
        for (long l : arr) {
            sum += l;
            if(hp + sum <= 0) {
                return true;
            }
        }
        if (sum > 0) return true;
        return false;
    }

    public static long[] generateArray(int size) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (long)(Math.random() * 2E6) - (long)1E6;
        }
        return arr;
    }

}
