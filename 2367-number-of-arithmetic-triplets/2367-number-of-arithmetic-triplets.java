class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // TC : O(n^2)
        // SC : O(1)
        
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n-2; i++){

            int j = i+1;
            int k = n-1;
            while(j < k){
                if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff){
                    ans++;
                    j++;
                    k--;
                }
                else if(nums[j] - nums[i] < diff){
                    j++;
                }
                else k--;
            }
        }
        return ans;
    }
}