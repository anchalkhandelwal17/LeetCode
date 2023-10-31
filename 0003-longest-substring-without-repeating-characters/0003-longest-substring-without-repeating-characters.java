class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int ans = Integer.MIN_VALUE;

        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j);
            j++;
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}