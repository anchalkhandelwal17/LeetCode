class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(list.contains(freq)){
                return false;
            }
            else list.add(freq);
        }
        return true;
    }
}