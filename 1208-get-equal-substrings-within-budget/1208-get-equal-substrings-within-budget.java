class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // TC : O(n)
        // SC : O(1)
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int cost = 0;
        for(int j=0; j<n; j++){
             cost += Math.abs(s.charAt(j) - t.charAt(j));

             if(cost > maxCost){
                while(i <= j && cost > maxCost){
                    cost -= Math.abs(s.charAt(i) - t.charAt(i));
                    i++;
                }
             }
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}