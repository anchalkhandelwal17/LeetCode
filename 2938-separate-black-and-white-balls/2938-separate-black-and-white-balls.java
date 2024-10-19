class Solution {
    public long minimumSteps(String s) {
        // TC : O(n)
        // SC : O(1)
        long ans = 0;
        int black = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '0'){
                ans = ans + (1l * black);
            }
            else black++;
        }
        return ans;
    }
}