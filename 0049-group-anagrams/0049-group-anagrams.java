class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // TC : O(n * max(str)log(str))
        // SC : O(n * k)
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        for(String key : map.keySet()){
            ans.add(new ArrayList<>(map.get(key)));
        }
        return ans;
    }
}