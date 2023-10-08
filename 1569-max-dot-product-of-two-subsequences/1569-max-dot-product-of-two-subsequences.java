class Solution {
    int n;
    int m;
    int[][] dp = new int[501][501];
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -100000000;
            }
        }
        return solve(0, 0, nums1, nums2);
    }

    public int solve(int i, int j, int[] nums1, int[] nums2){
        if(i == n || j == m){
            return -100000000;
        }
        if(dp[i][j] != -100000000){
            return dp[i][j];
        }
        int num = nums1[i] * nums2[j];
        int nums_i_j = nums1[i] * nums2[j] + solve(i+1, j+1, nums1, nums2);
        int nums_i = solve(i+1, j, nums1, nums2);
        int nums_j = solve(i, j+1, nums1, nums2);

        return dp[i][j] = Math.max(Math.max(num, nums_i_j), Math.max(nums_i, nums_j));
    }
}