class Solution {
    public int missingNumber(int[] nums) {
        // TC : O(n)
        // SC : O(1)
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for(int x : nums) actualSum += x;

        return totalSum - actualSum;
    }
}