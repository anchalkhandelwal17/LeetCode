class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        // TC : O(n^3)
        // SC : O(1)
        int n = words.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean isPrefixAndSuffix(String a, String b){
        int i=0, j=0;

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else return false;
        }
        if(i != a.length()) return false;

        i=0;
        j=b.length()-a.length();

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else return false;
        }
        if(i != a.length()) return false;

        return true;
    }
}