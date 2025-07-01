class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // TC : O(n * 26)
        // SC : O(26)
        int m = s1.length();
        int n = s2.length();
        if (m > n)
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int k = 0; k < m; k++) {
            char c = s1.charAt(k);
            freq1[c - 'a']++;
        }
        int i = 0;
        for (int j = 0; j < n; j++) {
            char c = s2.charAt(j);
            freq2[c - 'a']++;

            if (j - i + 1 == m && check(freq1, freq2)) {
                return true;
            }
            if (j - i + 1 == m) {
                freq2[s2.charAt(i) - 'a']--;
                i++;
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