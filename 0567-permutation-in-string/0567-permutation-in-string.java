class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // TC : O(m + n*26)
        // SC : O(26)
        int m = s1.length();
        int n = s2.length();
        if (m > n) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < m; i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        for (int j = 0; j < n; j++) {
            arr2[s2.charAt(j) - 'a']++;

            if (j - i + 1 > m) {
                arr2[s2.charAt(i) - 'a']--;
                i++;
            }

            if (j - i + 1 == m && check(arr1, arr2)) {
                return true;
            }
        }

        return false;
    }

    public boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
