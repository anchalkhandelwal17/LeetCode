class Solution {
    public long sumDigitDifferences(int[] nums) {
        // TC : O(10 * n * 10 * max(map.get(key)))
        // SC : O(10 * 10)
        int num = nums[0];
        int len = 0;
        int n = nums.length;
        while(num != 0){
            len++;
            num /= 10;
        }

        // same * unique
        long ans = 0;
        for(int i=0; i<len; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            find(nums, map, len);
            int val = 0;
            for(int key : map.keySet()){
                val = map.get(key);
                for(int k=0; k<val; k++){
                    ans = ans + (n - val);
                }
                // ans = ans + (val * (n - val));
            }
        }
        return ans/2;
    }
    
    public void find(int[] nums, HashMap<Integer,Integer> map, int len){
        int i = 0;
        while(i < nums.length){
            int a = nums[i] % 10;
            map.put(a, map.getOrDefault(a, 0)+1);
            nums[i] /= 10;
            i++;
        }
    }
}