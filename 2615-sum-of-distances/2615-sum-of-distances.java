class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = nums[i];
            if(!map.containsKey(val)){
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(i);
        }

        for(ArrayList<Integer> list : map.values()){
            long sum = 0;
            for(int val : list){
                sum += val;
            }

            long currSum = 0;
            long restSum = 0;
            for(int i=0; i<list.size(); i++){

                restSum = sum - currSum - list.get(i);

                long leftSum = (list.get(i) * (long)(i)) - currSum;

                long rightSum = restSum - ((list.size() - i - 1) * (long)list.get(i));

                ans[list.get(i)] = leftSum + rightSum;

                currSum += list.get(i);
            }
        }
        
        return ans;
    }
}