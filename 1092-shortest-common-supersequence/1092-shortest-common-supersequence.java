class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // TC : O(n * m) + O(n + m)
        // SC : O(n * m) + O(n + m) + recursion space
        int n = str1.length();
        int m = str2.length();

        String[][] dp = new String[n+1][m+1];

        String lcs = solve(0, 0, str1, str2, dp);

        StringBuilder ans = new StringBuilder();

        int i=0, j=0;

        for(int k=0; k<lcs.length(); k++){
            char c = lcs.charAt(k);

            while(i < n && str1.charAt(i) != c){
                ans.append(str1.charAt(i++));
            }
            while(j < m && str2.charAt(j) != c){
                ans.append(str2.charAt(j++));
            }
            ans.append(c);
            i++;
            j++;
        }

        ans.append(str1.substring(i));
        ans.append(str2.substring(j));

        return ans.toString();
    }

    public String solve(int i, int j, String a, String b, String[][] dp){
        // base case
        if(i >= a.length() || j >= b.length()){
            return "";
        }

        if(dp[i][j] != null) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            dp[i][j] = a.charAt(i) + solve(i+1, j+1, a, b, dp);
        }
        else{
            String incI = solve(i+1, j, a, b, dp);
            String incJ = solve(i, j+1, a, b, dp);

            dp[i][j] = (incI.length() >= incJ.length()) ? incI : incJ;
        }

        return dp[i][j];
    }
}