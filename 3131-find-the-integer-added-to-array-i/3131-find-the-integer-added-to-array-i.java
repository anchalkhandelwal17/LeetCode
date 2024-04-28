class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        
        int max1 = -1;
        int max2 = -1;
        for(int x : nums1){
            max1 = Math.max(max1, x);
        }
        for(int y : nums2){
            max2 = Math.max(max2, y);
        }
        return max2 - max1;
    }
}