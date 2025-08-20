class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0; i<m; i++){
            arr1[s1.charAt(i) - 'a']++;
        }

        int i=0;
        int j=0;
        while(j < n){
            arr2[s2.charAt(j) - 'a']++;

            if(j - i + 1 == m){
                if(check(arr1, arr2)) return true;
                arr2[s2.charAt(i) - 'a']--;
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