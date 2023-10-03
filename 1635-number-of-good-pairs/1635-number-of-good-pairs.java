class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int pairs = 0;
        Map<Integer,Integer> count = new HashMap<>();

        for(int e : nums){
            pairs += count.getOrDefault(e, 0);
            count.put(e, count.getOrDefault(e, 0)+1);
        }
        return pairs;  
    }
}