class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int m = (lo + hi) / 2;

            if(nums[m] == target) return m;

            else if(nums[lo] <= nums[m]){
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