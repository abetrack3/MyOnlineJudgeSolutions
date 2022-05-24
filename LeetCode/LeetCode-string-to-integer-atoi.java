import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    
    public static void main(String[] args) {
        String[] testCases = {
            "42",
            "   -42",
            "4193 with words",
            "  -0012a42",
            "",
            "-",
            "-20000000000000000000",
            "words and 987",
            ".1"
        };
        for (String test : testCases) {
            System.out.println(new Solution().myAtoi(test));
        }
    }
    
    public int myAtoi(String s) {
        s = s.trim();
        Pattern pattern = Pattern.compile("[+-]?[0-9]*");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        s = matcher.group();
        
        try {
            int num = Integer.parseInt(s);
            return num;
        } catch (NumberFormatException e) {
            return  s.matches("[+-]?") ? 0 :
                    s.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

}
