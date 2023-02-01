class Solution {
    public int trap(int[] height) {
        int maxHeight = 0;
        int total = 0;
        int[] trappedHeights = new int[height.length];
        
        for(int index = 0; index < height.length; index++) {
            int eachHeight = height[index];
            if (eachHeight > maxHeight) {
                maxHeight = eachHeight;
            }
            trappedHeights[index] = maxHeight - eachHeight;
        }

        maxHeight = 0;
        for(int index = height.length - 1; index >= 0; index--) {
            int eachHeight = height[index];
            if (eachHeight > maxHeight) {
                maxHeight = eachHeight;
            }
            trappedHeights[index] = Math.min(trappedHeights[index], maxHeight - eachHeight);
            total += trappedHeights[index];
        }

        return total;
    }
}