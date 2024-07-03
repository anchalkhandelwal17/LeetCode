class Solution {
    public int minDifference(int[] nums) {
        // TC : O(nlogn)
        // SC : O(1)
        int n = nums.length;
        if(n <= 3) return 0;
        Arrays.sort(nums);
        int ans1 = nums[n-4] - nums[0];
        int ans2 = nums[n-2] - nums[2];
        int ans3 = nums[n-1] - nums[3];
        int ans4 = nums[n-3] - nums[1];

        int ans = Math.min(Math.min(ans1, ans2), Math.min(ans3, ans4));
        return ans;
    }
}