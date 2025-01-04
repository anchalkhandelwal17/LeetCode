class Solution {
    public int countPalindromicSubsequence(String s) {
        // TC : O(n + 26 * (n + n + n))
        // SC : O(26 + (26 * 25))
        int n = s.length();
        if(n <= 2) return 0;

        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        int ans = 0;
        for(char c : set){
            int start = s.indexOf(c);
            int end = s.lastIndexOf(c);

            if(start < end){
                Set<Character> temp = new HashSet<>();

                for(int i=start+1; i < end; i++){
                    temp.add(s.charAt(i));
                }

                ans += temp.size();
            }
        }

        return ans;
    }
}