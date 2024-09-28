class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // TC : O(m + n*26)
        // SC : O(26) + O(26)
        int m = s1.length();
        int n = s2.length();
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i=0; i<m; i++){
            char c = s1.charAt(i);
            s1Freq[c - 'a']++;
        }
        int i=0;
        int j=0;
        while(j < n){
            char c = s2.charAt(j);
            s2Freq[c - 'a']++;
            if(j - i + 1 < m){
                j++;
            }
            else{
                if(check(s1Freq, s2Freq)){
                    return true;
                }
                s2Freq[s2.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }
        return false;
    }
    public boolean check(int[] arr1, int[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}