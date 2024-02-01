class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        if(n % 3 != 0) return new int[0][0];
        int[][] ans = new int[n/3][3];
        int j = 0;
        for(int i=0; i<n; i+=3){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            ans[j][0] = nums[i];
            ans[j][1] = nums[i+1];
            ans[j][2] = nums[i+2];
            j++;
        }
        return ans;
    }
}