class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int[] freqMap = new int[26];
        int maxFreq = 0;
        int ans = -1;

        while(j < n){
            char c = s.charAt(j);

            freqMap[c - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c - 'A']);

            while(j - i + 1 - maxFreq > k){
                freqMap[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}

// i = 0, j = 3
// maxCharCount = 2, k = 2;
// j - i + 1 - maxCharCount > k 
// minimize the window until this upper condition is satisfied

// 4 - 2 = 2 > k 