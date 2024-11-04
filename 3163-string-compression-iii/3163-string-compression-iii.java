class Solution {
    public String compressedString(String word) {
        // TC : O(n)
        // SC : O(n)
        StringBuilder ans = new StringBuilder();
        int n = word.length();

        int j = 0;
        while(j < n){
            int cnt = 1;
            while(j+1 < n && word.charAt(j) == word.charAt(j+1) && cnt < 9){
                cnt++;
                j++;
            }
            ans.append(cnt);
            ans.append(word.charAt(j));
            j++;
        }
        return ans.toString();
    }
}