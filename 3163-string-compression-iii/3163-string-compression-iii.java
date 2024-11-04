class Solution {
    public String compressedString(String word) {
        // TC : O(n)
        // SC : O(n)
        StringBuilder ans = new StringBuilder();
        int n = word.length();

        char prev = word.charAt(0);
        int j = 1;
        int cnt = 1;
        while (j < n) {
            char curr = word.charAt(j);

            if (prev == curr && cnt < 9) {
                cnt++;
            } else {
                ans.append(cnt);
                ans.append(prev);
                prev = curr;
                cnt = 1;
            }
            j++;
        }
        ans.append(cnt);
        ans.append(prev);
        return ans.toString();
    }
}