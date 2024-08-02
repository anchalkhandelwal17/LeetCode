class Solution {
    public int minimumDeletions(String word, int k) {
        // TC : O(n + (26 * 26))
        // SC : O(26)
        int n = word.length();
        int ans = Integer.MAX_VALUE;
        int[] freq = new int[26];
        for(int i=0; i<n; i++){
            char c = word.charAt(i);
            freq[c - 'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq[i] == 0) continue;
            int x = freq[i];
            int min = 0;
            for(int j=0; j<26; j++){
                if(freq[j] == 0) continue;
                int y = freq[j];

                if(y > (x + k)){
                    min += y - (x + k);
                }
                else if(y < x){
                    min += y;
                }
            }
            ans = Math.min(ans, min);
        }
        return ans;
    }
}