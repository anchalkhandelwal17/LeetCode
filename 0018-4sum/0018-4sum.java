class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j>(i+1) && nums[j] == nums[j-1]) continue;

                int start = j+1;
                int end = n-1;

                while(start < end){
                    long sum = nums[i] + nums[j];
                    sum += nums[start]; 
                    sum += nums[end];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start-1]) start++;
                        while(start < end && nums[end] == nums[end+1]) end--;
                    }
                    else if(sum > target) end--;
                    else start++;
                }
            }
        }
        return ans;
    }
}