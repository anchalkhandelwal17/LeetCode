class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        // TC : O(k * k)
        // SC : O(n)
        HashMap<String, Integer> map = new HashMap<>();
        int n = word.length();
        int ans = 0;
        String kPalinStr = "";
        int cnt = 0;
        for(int i=0; i<n; i+=k){
            String str = word.substring(i, i+k);
            map.put(str, map.getOrDefault(str, 0)+1);
            if(map.get(str) > cnt){
                cnt = map.get(str);
                kPalinStr = str;
            }
        }
        
        for(int i=0; i<n; i+=k){
            String str = word.substring(i, i+k);
            if(str.equals(kPalinStr)){
                continue;
            }
            else ans++;
        }
        return ans;
    }
}