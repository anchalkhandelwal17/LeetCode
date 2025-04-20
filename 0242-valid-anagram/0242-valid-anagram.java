class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        int[] freq1 = new int[26];
        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            freq1[a - 'a']++;
            freq1[b - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(freq1[i] != 0) return false;
        }
        return true;
    }
}