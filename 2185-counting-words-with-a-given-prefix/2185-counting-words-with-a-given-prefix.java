class Solution {
    public int prefixCount(String[] words, String pref) {
        // TC : O(n * len(max(len(maxOfWords), len(pref))))
        // SC : O(1)
        int n = words.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            String word = words[i];

            if(isPref(word, pref)){
                ans++;
            }
        }
        return ans;
    }

    // now let's try to implement something similar to startsWith

    public boolean isPref(String a, String b){
        int i = 0;
        int j = 0;

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) != b.charAt(j)){
                return false;
            }
            i++;
            j++;
        }
        return j == b.length();
    }
}