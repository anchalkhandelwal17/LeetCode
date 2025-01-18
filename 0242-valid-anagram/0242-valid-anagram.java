class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m != n) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i=0; i<m; i++){
            int a = s.charAt(i);
            int b = t.charAt(i);

            arr1[a - 'a']++;
            arr2[b - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}