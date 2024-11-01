class Solution {
    public String makeFancyString(String s) {
        // TC : O(n)
        // SC : O(n)
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int i = 0;
        while(i < n){
            HashMap<Character, Integer> map = new HashMap<>();
            char c = s.charAt(i);
            while(i + 1 < n && s.charAt(i) == s.charAt(i+1)){
                map.put(c, map.getOrDefault(c, 0)+1);
                i++;
            }
            map.put(c, map.getOrDefault(c, 0)+1);
            i++;
            for(int j=0; j<Math.min(2, map.get(c)); j++){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}