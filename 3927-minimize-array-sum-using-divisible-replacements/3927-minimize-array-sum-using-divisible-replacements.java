class Solution {
    public long minArraySum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        for(int i=0; i<n; i++){
            int num = nums[i];
            int val = num;

            for(int j=1; j*j<=num; j++){
                if(num % j == 0){
                    if(set.contains(j)){
                        val = Math.min(val, j);
                    }

                    int half = num / j;
                    if(set.contains(half)){
                        val = Math.min(val, half);
                    }
                }
            }
            sum += val;
        }
        return sum;
    }
}

// the range that could possibly divide the number completely it would be let's suppose
// 1000 => [1, 500] would be the range 

// if % is bigger

// [2, 3, 4, 8] 2 + 3 + 2 + 2 
// 2 -> [1] -> X
// 3 -> [1] -> X
// 4 -> [1,2] -> 2
// 8 -> [1,4] -> 2

// pair(a, b) -> a we have (b) we need to find
// (1....b/2) -> In this range find the minimum that divides the number completely
