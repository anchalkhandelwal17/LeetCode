class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(n < m) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int i = 0;

        for(int k=0; k<m; k++){
            char c = s1.charAt(k);
            freq1[c - 'a']++;
        }

        for(int j=0; j<n; j++){
            freq2[s2.charAt(j) - 'a']++;

            if(j - i + 1 > m){
                freq2[s2.charAt(i) - 'a']--;
                i++;
            }
            if(j - i + 1 == m && check(freq1, freq2)){
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] arr1, int[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

// in a particular permuted substring of s2 the freq of every char should
// be equal to the freq of every char in s1

// so we have to perform operations in s2
// and also prior we want the freq of chars in s1

// so we need to analyze every substr in s2 and check it with s1
// so to do this we just simply have to check for the frequencies
// and that should be same

