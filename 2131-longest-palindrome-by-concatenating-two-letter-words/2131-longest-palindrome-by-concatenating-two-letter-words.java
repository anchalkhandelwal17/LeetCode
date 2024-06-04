class Solution {
    public int longestPalindrome(String[] words) {
        // TC : O(n)
        // SC : O(n)
        int n = words.length;
        int ans = 0;
        boolean flag = false;
        // HashSet<String> set = new HashSet<>();
        // List<String> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words){
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.reverse();
            if(map.containsKey(sb.toString())){
                map.put(sb.toString(), map.getOrDefault(sb.toString(),0)-1);
                if(map.get(sb.toString()) == 0){
                    map.remove(sb.toString());
                }
                ans += 4;
            }
            else{
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }
        for(String x : map.keySet()){
            if(x.charAt(0) == x.charAt(1)){
                flag = true;
                break;
            }
        }
        return flag ? ans + 2 : ans;
    }
}
// fo => 8
// fq => 4
// ff => 2