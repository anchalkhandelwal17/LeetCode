class Solution {
    public int maxScore(String s) {
        // TC : O(n^2)
        // SC : O(1)
        int ans = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            if(i == n-1) continue;
            
            int cnt1 = 0;
            int cnt2 = 0;

            for(int j=0; j<=i; j++){
                if(s.charAt(j) == '0') cnt1++;
            }

            for(int k=i+1; k<n; k++){
                if(s.charAt(k) == '1') cnt2++;
            }

            ans = Math.max(ans, cnt1 + cnt2);
        }

        return ans;
    }
}