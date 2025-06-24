class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // TC : O(n * max(strs[i]log(strs[i])))
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String newStr = new String(ch);
            if(!map.containsKey(newStr)){
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        for(String k : map.keySet()){
            ans.add(map.get(k));
        }
        return ans;
    }
}