class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        
        int maxSum = Integer.MIN_VALUE;
        
        while(start < end){
            int currSum = nums[start] + nums[end];
            maxSum = Math.max(maxSum, currSum);
            
            start++;
            end--;
        }
        
        return maxSum;
    }
}