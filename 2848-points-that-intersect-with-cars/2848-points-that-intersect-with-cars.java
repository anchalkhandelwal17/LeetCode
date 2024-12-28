class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        // TC : O(n^2)
        // SC : O(n)
        
        int n = nums.size();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=nums.get(i).get(0); j<=nums.get(i).get(1); j++){
                set.add(j);
            }
        } 
        return set.size();
    }
}