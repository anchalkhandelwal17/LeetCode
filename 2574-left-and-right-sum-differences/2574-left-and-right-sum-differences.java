class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n = nums.length;
        int[] lSum = new int[n];
        int[] rSum = new int[n];
        int[] ans = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            lSum[i] = sum;
            sum += nums[i];
        }
        
        sum = 0;
        
        for(int i=n-1; i>=0; i--){
            rSum[i] = sum;
            sum += nums[i];
        }
        
        for(int i=0; i<n; i++){
            ans[i] = Math.abs(lSum[i] - rSum[i]);
        }
        return ans;
    }
}