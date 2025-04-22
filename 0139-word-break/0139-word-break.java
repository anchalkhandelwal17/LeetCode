class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // TC : O(n^2)
        // SC : O(n + m*k)
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordDict.size(); i++){
            String str = wordDict.get(i);
            set.add(str);
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        return solve(set, s, 0, map);
    }

    public boolean solve(HashSet<String> set, String s, int i, HashMap<Integer, Boolean> map) {
        if(i == s.length()){
            return true;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }

        for(int idx=i; idx<s.length(); idx++){
            String subStr = s.substring(i, idx+1);
            if(set.contains(subStr)){
                if(solve(set, s, idx+1, map)){
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    }
}