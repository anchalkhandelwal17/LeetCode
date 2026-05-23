class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(i == j) continue;

                ans = Math.min(ans, solve(nums, k, i, j));
            }
        }
        return ans;
    }
    public int solve(int[] nums, int k, int x, int y){
        int ops = 0;
        for(int i=0; i<nums.length; i++){
            int rem = nums[i] % k;
            if(i%2 == 0){
                // x
                ops += Math.min(Math.abs(rem - x), k - Math.abs(rem - x));
            }
            else{
                // y
                ops += Math.min(Math.abs(rem - y), k - Math.abs(rem - y));
            }
        }
        return ops;
    }
}
