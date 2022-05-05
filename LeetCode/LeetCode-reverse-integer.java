import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;


class Solution {

    public static AtomicReference<StringBuilder> progressBar;
    public static AtomicLong counter;
    public static final long FROM, TO, LIMIT;

    static {
        progressBar = new AtomicReference<StringBuilder>(new StringBuilder());
        progressBar.get().append("["+".".repeat(100)+"]");
        counter = new AtomicLong();
        FROM = Integer.MIN_VALUE;
        TO = Integer.MAX_VALUE;
        LIMIT = TO - FROM + 1;
    }

    public static void updateProgressBar() {
        long current = counter.getAndIncrement();
        int percent = (int) (100 * current / LIMIT) + 1;
        progressBar.get().setCharAt(percent, '#');
        System.out.printf("\r" + progressBar.get() + " (%d/%d)", counter.get(), LIMIT);
    }

    public static void main(String[] args) throws InterruptedException {
        Solution a = new Solution();
        // a.test();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(a.reverseUsingString(scanner.nextInt()));
        }
    }

    public int reverse(int x) {
        if (Integer.MAX_VALUE == x || Integer.MIN_VALUE == x) { return 0; }

        int ans = 0;
        while (x != 0) {
            int temp = ans * 10;
            int mod = x % 10;
            temp += mod;
            if (temp / 10 != ans) {
                return 0;
            }
            ans = temp;
            x /= 10;
        }
        return ans;
    }

    public int reverseUsingString(int x) {
        boolean neg = x < 0;
        String numberString = new StringBuilder(
                Integer
                    .toString(x)
                    .replaceFirst("-", "")
            )
            .reverse()
            .insert(0, neg ? '-' : ' ')
            .toString()
            .trim();
            try {
                int number = Integer.parseInt(numberString);
                return number;
            } catch (Exception e) {
                return 0;
            }
    }

    public void test() {
        AtomicBoolean flag = new AtomicBoolean(true);
        IntStream.rangeClosed((int) FROM, (int) TO)
        .parallel()
        .forEach(val -> {
            updateProgressBar();
            if (flag.get()) {
                if (reverse(val) != reverseUsingString(val)) {
                    flag.set(false);
                    System.out.println("Error case: " + val);
                    System.out.println("reverse: " + reverse(val));
                    System.out.println("reverseUsingSystem: " + reverseUsingString(val));
                }
            }
        });
    }

}
