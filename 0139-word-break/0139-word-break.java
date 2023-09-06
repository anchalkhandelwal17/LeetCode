class Solution {
    private Map<String,Boolean> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();

        return helper(s, new HashSet<>(wordDict));
    }

    public boolean helper(String s, HashSet<String> set){
        if(s.length() == 0){
            return true;
        }

        if(dp.containsKey(s)){
            return dp.get(s);
        }
        for(int i=0; i<s.length(); i++){
            String st = s.substring(0, i+1);
            if(set.contains(st)){
                if(helper(s.substring(i+1), set)){
                    dp.put(s, true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }
}