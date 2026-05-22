class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        int[] arr = new int[26];
        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            arr[a - 'a']++;
            arr[b - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
}