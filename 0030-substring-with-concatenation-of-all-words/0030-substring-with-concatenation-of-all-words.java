class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = words[0].length();

        for(String str : words){
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        for(int i=0; i<=s.length() - len * words.length; i++){

            HashMap<String, Integer> words_map = new HashMap<>(map);

            for(int j=0; j<words.length; j++){

                String substr = s.substring(i + j*len , i + j*len + len);

                if(words_map.containsKey(substr)){
                    if(words_map.get(substr) == 1) words_map.remove(substr);
                    else words_map.put(substr, words_map.get(substr)-1);
                    
                    if(words_map.isEmpty()){
                        ans.add(i);
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }

        return ans;
    }
}