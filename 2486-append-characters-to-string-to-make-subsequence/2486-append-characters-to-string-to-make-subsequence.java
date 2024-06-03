class Solution {
    public int appendCharacters(String s, String t) {
        // TC : O(max(m, n))
        // SC : O(1)
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();

        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;
        }
        return n-j;
    }
}