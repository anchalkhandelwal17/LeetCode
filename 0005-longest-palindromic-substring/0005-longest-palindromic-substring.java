class Solution {
    public String longestPalindrome(String s) {
        
        // expanding from the centres and checking , O(n ^ 2) solutioin.

        int resLen = 0;
        String res = "";

        for(int i=0; i<s.length(); i++){

            // odd length

            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > resLen){
                    res = s.substring(l, r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

            // even length

            l = i;
            r = i+1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > resLen){
                    res = s.substring(l, r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

        }

        return res;
    }
}