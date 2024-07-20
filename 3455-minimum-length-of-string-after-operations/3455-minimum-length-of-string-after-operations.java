class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int ans = 0;
        for(char c : map.keySet()){
            int val = map.get(c);
            if(val % 2 == 1) ans+= 1;
            else ans += 2;
        }
        return ans;
    }
}