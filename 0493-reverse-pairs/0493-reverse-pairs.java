class Solution {
    public int reversePairs(int[] nums) {
       // TC : O(2n * logn)
       // SC : O(n)
        return ms(nums, 0, nums.length-1);
    }

    public int ms(int[] nums, int lo, int hi){
        int count = 0;
        // base condition
        if(lo >= hi){
            return count;
        }
        int mid = (lo + hi)/2;

        count += ms(nums, lo, mid);
        count += ms(nums, mid+1, hi);
        count += countPairs(nums, lo, mid, hi);
        merge(nums, lo, mid, hi);
        return count;
    }

    public void merge(int[] nums, int lo, int mid, int hi){
        ArrayList<Integer> list = new ArrayList<>();

        int i = lo;
        int j = mid+1;

        while(i <= mid && j <= hi){
            if(nums[i] <= nums[j]){
                list.add(nums[i]);
                i++;
            }
            else{
                list.add(nums[j]);
                j++;
            }
        }

        while(i <= mid){
            list.add(nums[i]);
            i++;
        }

        while(j <= hi){
            list.add(nums[j]);
            j++;
        }

        for(int start=lo; start<=hi; start++){
            nums[start] = list.get(start-lo);
        }
    }

    // for counting the number of pairs
    public int countPairs(int[] nums, int lo, int mid, int hi){
        int count = 0;
        int right = mid+1;
        for(int i=lo; i<=mid; i++){

            while(right<=hi && nums[i] > 2L * nums[right]){
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
}