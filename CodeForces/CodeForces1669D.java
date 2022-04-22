import java.util.Scanner;

public class CodeForces1669D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test --> 0) {
            sc.nextLine(); //dummy input
            String[] s = sc.nextLine().split("W");
            boolean flag = true;
            for (String subString : s) {
                if (subString.length() == 0) {
                    continue;
                } else if (subString.length() == 1) {
                    flag = false;
                    break;
                } else if (subString.length() == 2) {
                    if (subString.equals("BB") || subString.equals("RR")) {
                        flag = false;
                        break;
                    }
                } else {
                    boolean allCharactersSame = true;
                    for (int i = 1; i < subString.length(); i++) {
                        if (subString.charAt(i) != subString.charAt(i - 1)) {
                            allCharactersSame = false;
                            break;
                        }
                    }
                    if (allCharactersSame) {
                        flag = false;
                        break;
                    }
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
