class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // TC : O(n*mlogm)
        int n = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
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
        return new ArrayList<>(map.values());
    }
}