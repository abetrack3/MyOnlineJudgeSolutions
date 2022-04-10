class Solution {
    public int[] sumZero(int n) {
        
        int[] ans = new int[n];
        // int i = (n % 2 == 0) ? 0 : 1;
        for(int j = 1, i = (n % 2 == 0) ? 0 : 1; i + 1 < ans.length; i+=2, j++){
            ans[i] = j;
            ans[i+1] = -j;
        }
        return ans;
    }
}