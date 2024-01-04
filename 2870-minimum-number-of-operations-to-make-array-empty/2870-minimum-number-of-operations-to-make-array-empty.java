class Solution {
    public int minOperations(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int e : nums){
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        
        for(int e : map.keySet()){
            if(map.get(e) == 1) return -1;
            else if(map.get(e) == 2 || map.get(e) == 3) ans += 1;
            // if(map.get(e) % 3 == 0) {
            //     ans += map.get(e)/3;
            // }
            // else if(map.get(e) % 2 == 0){
            //     ans += map.get(e)/2;
            // }
            // else{
                // int rem = map.get(e) % 3;    
                // if(rem == 1){
                //     ans += (map.get(e)/3)-1;
                //     and += 2;
                // }
                // else{
                //     ans += map.get(e)/3;
                //     ans += 1;
                // }
            else{
                int rem = map.get(e) % 3;
                 ans += map.get(e)/3;
                if(rem != 0) ans++;
            }
            // }
        }
        return ans;
    }

// [2,3,3,2,2,4,2,3,4] -> 0,3  2,4                  2 + 1 +
// [2,2,2,2,3,3,3,4,4]

// 4 + 3   14:10   12:9
}