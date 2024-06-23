class Solution {
    public double minimumAverage(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Double> list = new ArrayList<>();
        int i=0;
        int j=n-1;
        while(i < j){
            float val = (float)(nums[i] + nums[j]) / 2;
            list.add((double)val);
            i++;
            j--;
        }
        Collections.sort(list);
        return list.get(0);
    }
}