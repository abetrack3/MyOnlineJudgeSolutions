class Solution {
    

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        for(int i=0, j=0, k=0; i<arr.length; i++) {
            if(j == nums1.length){
                arr[i] = nums2[k++];
            } else if(k == nums2.length){
                arr[i] = nums1[j++];
            } else if(nums1[j] > nums2[k]){
                arr[i] = nums2[k++];
            } else{
                arr[i] = nums1[j++];
            }
        }

        if(arr.length % 2 == 0){
            return (double)(arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }

        return (double)(arr[arr.length / 2]);
    }
}