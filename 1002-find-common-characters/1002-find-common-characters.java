class Solution {
    public List<String> commonChars(String[] words) {
        // TC : O(k + n*k*26 + 26*max(map1[i])) => O(n*k)
        // SC : O(26 + n*26)
        int[] map1 = new int[26];
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for(int i=0; i<words[0].length(); i++){
            map1[words[0].charAt(i) - 'a']++;
        }

        for(int i=1; i<n; i++){
            int[] map2 = new int[26];
            for(int k=0; k<words[i].length(); k++){
                map2[words[i].charAt(k) - 'a']++;
            }
            for(int z=0; z<26; z++){
                map1[z] = Math.min(map1[z], map2[z]);
            }
        }
        for(int i=0; i<26; i++){
            // char c = (char)(i + 'a');
            for(int j=0; j<map1[i]; j++){
                // ans.add(c+"");
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }
        return ans;
    }
}