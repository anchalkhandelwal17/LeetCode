class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            String word = words[i];

            if(word.startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }
}