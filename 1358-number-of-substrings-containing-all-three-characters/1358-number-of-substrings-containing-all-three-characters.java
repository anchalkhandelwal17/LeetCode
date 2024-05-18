class Solution {
    public int numberOfSubstrings(String s) {
        // TC : O(n)
        // SC : as there is only a,b or c as the input
        // so we can say space complexity will be constatnt
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int j = 0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);

            if(map.size() == 3){
                while(j <= i && map.size() == 3){
                    char ch = s.charAt(j);
                    map.put(ch, map.getOrDefault(ch, 0)-1);
                    if(map.get(ch) <= 0){
                        map.remove(ch);
                    }
                    j++;
                    ans = ans + n-i;
                }
            }
        }
        return ans;
    }
}