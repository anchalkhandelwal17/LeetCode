class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int n = nums.length;
        int start = 0;
        int end = 0;
        long totalSum = 0;

        while(end < n){
            totalSum += nums[end];

            while(start < n && nums[end] * (end - start + 1L) > totalSum + k){
                totalSum -= nums[start];
                start++;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
    }
    return ans;
    }
}