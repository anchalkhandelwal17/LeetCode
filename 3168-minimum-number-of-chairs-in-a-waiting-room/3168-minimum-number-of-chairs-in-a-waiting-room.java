class Solution {
    public int minimumChairs(String s) {
        // TC : O(n)
        // SC : O(1)
        int ans = 0;
        int curr = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'E') curr++;
            else curr--;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}