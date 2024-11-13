class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // TC : O(nlogn)
        // SC : O(1)
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for(int i=0; i<n; i++){

            long lb = bs(nums, i+1, n-1, lower - nums[i]);

            long ub = bs(nums, i+1, n-1, upper - nums[i]+1);

            ans = ans + (ub - lb);
        }
        return ans;
    }

    public int bs(int[] nums, int lo, int hi, int x){
        while(lo <= hi){
            int m = (lo + hi)/2;

            if(nums[m] >= x){
                hi = m-1;
            }
            else lo = m+1;
        }
        return lo;
    }
}
