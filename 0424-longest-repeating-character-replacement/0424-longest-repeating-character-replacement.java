class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int start = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for(int end = 0; end<s.length(); end++){

            maxFreq = Math.max(maxFreq , ++count[s.charAt(end) - 'A']);

            if(end - start + 1 - maxFreq > k){
                --count[s.charAt(start) - 'A'];
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}