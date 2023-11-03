class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0 || p.length() > s.length()){
            return ans;
        }

        int[] map = new int[26];
        int right = 0;
        int left = 0;

        for(int i=0; i<p.length(); i++){
            map[p.charAt(i) - 'a']++;
        }

        while(right < s.length()){

            if(map[s.charAt(right) - 'a'] > 0){
                map[s.charAt(right++) - 'a']--;

                if(right - left == p.length()){
                    ans.add(left);
                }
            }


            // else if(right == left){
            //     right++;
            //     left++;
            // }

            else{
                map[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return ans;
    }
}