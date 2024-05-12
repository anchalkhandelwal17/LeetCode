class Solution {
    public int findPermutationDifference(String s, String t) {
        // TC : O(n)
        // SC : O(n)
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        for(int i=0; i<t.length(); i++){
            
            ans = ans + Math.abs(map.get(t.charAt(i)) - i);
        }
        return ans;
    }
}