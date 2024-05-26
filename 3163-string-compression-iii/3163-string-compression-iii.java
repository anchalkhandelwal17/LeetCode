class Solution {
    public String compressedString(String word) {
        // TC : O(n)
        // SC : O(2*n)
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int n = word.length();
        
        while(i < n){
            int len = 0;
            int j = i;
            char c = word.charAt(i);
            while(i < n && i+1 < n && word.charAt(i) == word.charAt(i+1) && i < j+8){
                len++;
                i++;
            }
            i++;
            ans.append(len+1);
            ans.append(c);
        }
        return ans.toString();
    }
}