class Solution {
    public int scoreOfString(String s) {
        // TC : O(n)
        // SC : O(1)
        int ans = 0;
        int n = s.length();
        for(int i=0; i<n-1; i++){
            ans = ans + (Math.abs(s.charAt(i) - s.charAt(i+1)));
        }
        return ans;
    }
}