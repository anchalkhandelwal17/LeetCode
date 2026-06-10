class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        HashSet<String> set = new HashSet<>();
        HashMap<Integer, Boolean> dp = new HashMap<>();
        for(int i=0; i<n; i++){
            set.add(wordDict.get(i));
        }

        return solve(s, 0, set, dp);
    }

    public boolean solve(String s, int idx, HashSet<String> set, HashMap<Integer, Boolean> dp){
        // base case
        if(idx >= s.length()){
            return true;
        }

        if(dp.containsKey(idx)){
            return dp.get(idx);
        }

        for(int i=idx; i<s.length(); i++){
            if(set.contains(s.substring(idx, i+1))){
                if(solve(s, i+1, set, dp)){
                    return true;
                }
            }
        }

        dp.put(idx, false);
        return false;
    }
}