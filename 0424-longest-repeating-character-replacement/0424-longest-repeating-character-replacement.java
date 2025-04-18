class Solution {
    public int characterReplacement(String s, int k) {
        // TC : O(n)
        // SC : O(26)
        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;
        int[] freq = new int[26];
        int i=0;
        for(int j=0; j<n; j++){
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(j) - 'A']);

            while(j - i + 1 - maxFreq > k){
                --freq[s.charAt(i) - 'A'];
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}