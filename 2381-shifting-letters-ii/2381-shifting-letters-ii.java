class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] pref = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2] == 0 ? -1 : 1;
            pref[start] += dir;
            pref[end + 1] -= dir;
        }

        int shiftAmount = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            shiftAmount += pref[i];
            char c = s.charAt(i);

            int newChar = ((c - 'a') + (shiftAmount % 26) + 26) % 26 + 'a';
            ans.append((char) newChar);
        }

        return ans.toString();
    }
}

// 0 = back
// 1 = forw