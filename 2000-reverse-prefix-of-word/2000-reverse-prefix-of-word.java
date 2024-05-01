class Solution {
    public String reversePrefix(String word, char ch) {
        // TC : O(n+n)
        // SC : O(n)
        StringBuilder ans = new StringBuilder();
        int n = word.length();

        for(int i=0; i<n; i++){
            char c = word.charAt(i);

            if(c == ch){
                for(int j=i; j>=0; j--){
                    ans.append(word.charAt(j));
                }
                ans.append(word.substring(i+1));
                return ans.toString();
            }
        }
        return word;
    }
}