class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1){
            return (double)(nums[0]);
        }
        double ans = (double)(Integer.MIN_VALUE);
        double sum = 0.0;
        int j=0;
        int i=0;

        while(j < nums.length){
            sum += nums[j];
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                ans = Math.max(ans, sum);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return ans/1.0/k;
    }
}