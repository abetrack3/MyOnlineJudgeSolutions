import java.util.Scanner;

public class CodeForces1060A {
    public static void main(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = Integer.parseInt(scanner.nextLine());
            int count8 = (int) scanner
                            .nextLine()
                            .chars()
                            .mapToObj(Character::toString)
                            .filter((String c) -> c.equals("8"))
                            .count();
            int countOthers = size - count8;
            int ans = Math.min(countOthers / 10, count8);
            count8 -= ans;
            countOthers -= 10 * ans;
            if (count8 > 0 && count8 + countOthers >= 11) {
                ans += (count8 + countOthers) / 11;
            }
            System.out.println(ans);
        } catch (NumberFormatException ignored) {}
    }
}
