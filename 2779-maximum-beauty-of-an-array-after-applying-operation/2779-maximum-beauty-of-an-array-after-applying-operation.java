class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // TC : O(nlogn)
        // SC : O(1)
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<n; i++){
            int ub = check(nums, nums[i] + 2*k);
            ans = Math.max(ans, ub - i + 1);
        }
        return ans;
    }

    public int check(int[] nums, int val){
        int lo = 0;
        int hi = nums.length-1;
        int ans = 0;

        while(lo <= hi){
            int mid = (lo + hi)/2;

            if(nums[mid] <= val){
                ans = mid;
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return ans;
    }
}