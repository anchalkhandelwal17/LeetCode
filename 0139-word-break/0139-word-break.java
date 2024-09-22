class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // TC : O(n)
        // SC : O(n)
        int n = wordDict.size();
        HashSet<String> set = new HashSet<>();
        HashMap<Integer, Boolean> dp = new HashMap<>();
        for(int i=0; i<n; i++){
            String str = wordDict.get(i);
            set.add(str);
        }
        return solve(0, s, set, dp); 
    }

    public boolean solve(int i, String s, HashSet<String> set,
     HashMap<Integer, Boolean> dp){
        // base condition
        if(i >= s.length()){
            return true;
        }

        if(dp.containsKey(i)){
            return dp.get(i);
        }

        for(int idx=i; idx<s.length(); idx++){
            String str = s.substring(i, idx+1);
            if(set.contains(str)){
                if(solve(idx+1, s, set, dp)){
                    return true;
                }
            }
        }
        dp.put(i, false);
        return false;
    }
}