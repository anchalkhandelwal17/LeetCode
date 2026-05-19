class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // TC : O(n + m*26)
        // SC : O(26 * 2)
        int n = s1.length();
        int m = s2.length();

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i=0; i<n; i++){
            s1Map[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        while(j < m){
            s2Map[s2.charAt(j) - 'a']++;

            if(j - i + 1 == n){
                if(check(s1Map, s2Map)){
                    return true;
                }

                s2Map[s2.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return false;
    }
    public boolean check(int[] arr1, int[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}