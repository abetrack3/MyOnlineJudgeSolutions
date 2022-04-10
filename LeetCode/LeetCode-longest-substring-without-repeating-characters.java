class Solution {
    public int lengthOfLongestSubstring(String s) {

        // base case
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int maxLength = 0, start = 0;
        int[] index = new int[256];
        java.util.Arrays.fill(index, -1);

        for(int end = 0; end < s.length(); end++){
            if(index[(int)s.charAt(end)] != -1){ // repeating character found
                start = Math.max(start, index[(int)s.charAt(end)] + 1);
            }
            index[(int)s.charAt(end)] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;

    }
}