class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // TC : O(n * m)
        // SC : O(1)
        int n = sentence.length();
        int j = 0;
        int m = searchWord.length();
        int idx = -1;
        for(int i=0; i<n; i++){

            if(sentence.charAt(i) == searchWord.charAt(j)){
                while(j < m && i < n && sentence.charAt(i) == searchWord.charAt(j)){
                    i++;
                    j++;
                }
                if(j == m) return idx+2;
                j = 0;
            }

            while(i < n && sentence.charAt(i) != ' '){
                i++;
            }
            idx++;
        }
        return -1;
    }
}