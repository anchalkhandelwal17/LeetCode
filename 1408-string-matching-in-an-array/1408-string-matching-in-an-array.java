class Solution {
    public List<String> stringMatching(String[] words) {
        // TC : O(n^2)
        // SC : O(n)

        int n = words.length;
        List<String> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = words[i];
            for(int j=0; j<n; j++){
                if(i == j) continue;
                String curr = words[j];
                if(curr.indexOf(str) != -1){
                    ans.add(str);
                    break;
                }
            }
        }
        return ans;
    }
}