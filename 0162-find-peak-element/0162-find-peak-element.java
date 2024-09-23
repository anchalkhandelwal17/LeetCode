class Solution {
    public int findPeakElement(int[] nums) {
        // TC : O(log n)
        // SC : O(1)
        int n = nums.length;
        if(n == 1) return 0;
        else if(nums[0] > nums[1]) return 0;
        else if(nums[n-1] > nums[n-2]) return n-1;

        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int m = (lo + hi)/2;

            if(m-1 >= 0 && m+1 < n && nums[m] > nums[m-1] && nums[m] > nums[m+1]){
                return m;
            }
            else if(m-1 >= 0 && nums[m-1] > nums[m]){
                hi = m;
            }
            else lo = m;
        }
        return -1;
    }
}

// brute force can be applied
// think of some other optimised approach 