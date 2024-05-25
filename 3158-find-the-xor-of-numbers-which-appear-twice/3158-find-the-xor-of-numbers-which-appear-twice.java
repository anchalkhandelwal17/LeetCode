class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for(int key : map.keySet()){
            int val = map.get(key);
            
            if(val == 2){
                ans ^= key;
            }
        }
        return ans;
    }
}