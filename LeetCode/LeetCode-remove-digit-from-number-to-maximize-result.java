public class Solution {
    public static void main(String[] args) {
        String[][] testCases = {{"123", "3"}, {"1231", "1"}, {"551", "5"}};
        for(String[] test : testCases) {
            String number = test[0];
            char digit = test[1].charAt(0);
            System.out.println(new Solution().removeDigit(number, digit));
        }
    }

    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder(number);
        char[] digits = number.toCharArray();
        boolean flag = false;
        int index = -1;
        for (int i = 1; i < digits.length; i++) {
            if (digits[i - 1] == digit && digits[i] > digit) {
                flag = true;
                index = i - 1;
                break;
            }
        }
        if (!flag) {
            index = number.lastIndexOf(digit);
        }
        sb.deleteCharAt(index);
        return sb.toString();
    }

}
