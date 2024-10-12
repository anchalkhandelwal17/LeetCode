class Solution {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        // TC : O(n*m)
        // SC : O(n*m) + rec space
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : targetIndices) set.add(i);
        int n = source.length();
        int m = pattern.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, source, pattern, set, dp);
    }

    public int solve(int i, int j, String source, String pattern, HashSet<Integer> set, 
    int[][] dp){
        // base case
        int ans = 0;
        if(i == source.length()){
            if(j == pattern.length()) return 0;
            return -100000007;
        }

        if(dp[i][j] != -1) return dp[i][j];

        ans = solve(i+1, j, source, pattern, set, dp);

        if(set.contains(i)){
            ans = Math.max(ans, 1 + solve(i+1, j, source, pattern, set, dp));
        }

        if(j < pattern.length() && source.charAt(i) == pattern.charAt(j)){
            ans = Math.max(ans, solve(i+1, j+1, source, pattern, set, dp));
        }

        dp[i][j] = ans;
        return ans;

    }
}