class Solution {
    public int minAnagramLength(String s) {

        int n = s.length();
        for (int i = 1; i < n; i++) {
            if(n % i == 0){
                if(check(s, i)){
                    return i;
                }
            }
        }
        return n;
    }

    public boolean check(String s, int idx){
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0; i<idx; i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int j=idx; j<n; j+=idx){
            int[] freq2 = new int[26];
            for(int k=j; k<j+idx; k++){
                freq2[s.charAt(k) - 'a']++;
            }
            for(int i=0; i<26; i++){
                if(freq[i] != freq2[i]){
                    return false;
                }
            }
        }
        return true;
    }
}