class Solution {
    public int search(int[] nums, int target) {
        // TC : O(logn)
        // SC : O(1)

        int n = nums.length;
        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi){
            int m = (lo + hi) / 2;

            if(nums[m] == target) return m;

            if(nums[m] >= nums[lo]){
                if(target >= nums[lo] && target < nums[m]){
                    hi = m-1;
                }
                else lo = m+1;
            }
            else{
                if(target > nums[m] && target <= nums[hi]){
                    lo = m+1;
                }
                else hi = m-1;
            }

        }
        return -1;
    }
}