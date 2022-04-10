import java.util.Scanner;

class Solution {

    int maxLength = 1, from = 0, to = 0;
    char[] c;

    public String longestPalindrome(String s) {
        c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            maxPalindrome(i, i);
            maxPalindrome(i, i + 1);
        }
        return s.substring(from, to + 1);
    }

    public void maxPalindrome(int left, int right) {
        for(;left >= 0 && right < c.length; left--, right++) {
            if(c[left] != c[right]) {
                left++;
                right--;
                break;
            }
        }
        if(left == -1 || right == c.length) {
            left++;
            right--;
        }
        if(right - left + 1 > maxLength) {
            maxLength = right - left + 1;
            from = left;
            to = right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = new Solution().longestPalindrome(s);
        System.out.println(res);
        scanner.close();
    }

}