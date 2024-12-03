class Solution {
    public String addSpaces(String s, int[] spaces) {
        // TC : O(n)
        // SC : O(n)
        int n = s.length();
        int m = spaces.length;
        int idx = 0;
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(idx < m && i == spaces[idx]){
                idx++;
                ans.append(' ');
            }

            ans.append(c);
        }
        return ans.toString();
    }
}