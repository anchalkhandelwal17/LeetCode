class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n)
        // SC : O(n)
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int n = s.length();

        while(j < n){

            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j))+1);
            }

            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j);
            j++;
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}