class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n)
        // SC : O(n) 
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}