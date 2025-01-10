class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words2.length;
        int m = words1.length;
        int[][] freq1 = new int[m][26];
        int[] freq2 = new int[26];

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < words1[i].length(); j++) {
                char c = words1[i].charAt(j);

                freq1[i][c - 'a']++;
            }
        }

        for (int i = 0; i < n; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < words2[i].length(); j++) {
                char c = words2[i].charAt(j);

                temp[c - 'a']++;

                freq2[c - 'a'] = Math.max(freq2[c - 'a'], temp[c - 'a']);
            }
        }

        for(int i=0; i<m; i++){
            boolean flag = true;

            for(int k=0; k<26; k++){
                if(freq1[i][k] < freq2[k]){
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(words1[i]);
        }
        return ans;
    }
}

