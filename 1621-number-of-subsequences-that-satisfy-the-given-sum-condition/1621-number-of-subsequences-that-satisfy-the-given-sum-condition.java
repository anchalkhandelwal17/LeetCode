class Solution {
    public int numSubseq(int[] nums, int target) {
        // TC : O(nlogn)
        // SC : O(n)
        Arrays.sort(nums);
        int mod = (int)(1e9) + 7;
        int[] pow = new int[nums.length];

        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                ans = (ans + pow[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
