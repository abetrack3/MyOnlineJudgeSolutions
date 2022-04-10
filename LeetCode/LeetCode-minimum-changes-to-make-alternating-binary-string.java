class Solution {
    public int minOperations(String s) {
        char [] arr = s.toCharArray();
        char x = '1', y = '0';
        int diff1 = 0, diff2 = 0;
        for(char a : arr){
            if(a == x) diff1++;
            if(a == y) diff2++;
            x ^= y;
            y ^= x;
            x ^= y;
        }
        return Math.min(diff1, diff2);
        
    }
}