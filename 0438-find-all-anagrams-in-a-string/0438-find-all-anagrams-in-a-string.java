class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] char_cnt = new int[128];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<p.length(); i++){
            char_cnt[p.charAt(i)]++;
        }
        for(int r=0, l=0; r<s.length(); r++){
            char c = s.charAt(r);
            char_cnt[c]--;

            while(char_cnt[c] < 0){
                char_cnt[s.charAt(l)]++;
                l++;
            }

            if(r - l + 1 == p.length()){
                ans.add(l);
            }
        }
        return ans;
    }
}