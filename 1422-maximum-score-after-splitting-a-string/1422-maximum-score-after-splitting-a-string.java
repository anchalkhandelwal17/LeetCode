class Solution {
    public int maxScore(String s) {
        
        int ans = Integer.MIN_VALUE;
        int ones = 0;
        int zeroes = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') ones++;
        }
        
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == '1') ones--;
            else zeroes++;
            
            ans = Math.max(ans, zeroes + ones);
        }
        return ans;
    }
}