class Solution {
    public boolean isCircularSentence(String sentence) {
        // TC : O(n)
        // SC : O(n)
        String[] str = sentence.split("\\s+");
        int n = str.length;

        for(int i=0; i<n; i++){
            if(i+1 < n && str[i].charAt(str[i].length()-1) != str[i+1].charAt(0)){
                return false;
            }
        }
        return str[0].charAt(0) == str[n-1].charAt(str[n-1].length()-1);
    }
}