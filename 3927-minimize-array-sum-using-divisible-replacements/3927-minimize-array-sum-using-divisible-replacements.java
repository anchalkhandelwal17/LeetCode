class Solution {
    public long minArraySum(int[] nums) {
        // TC : O(nlogn + n*sqrt(n)*log(n))
        // SC : constant
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int best = num;
            for (int j = 1; j * j <= num; j++) {
                if (num % j == 0) {
                    if (check(nums, j)) {
                        best = Math.min(best, j);
                    }
                    int val = num / j;
                    if (check(nums, val)) {
                        best = Math.min(best, val);
                    }
                }
            }
            sum += best;
        }
        return sum;
    }

    public boolean check(int[] nums, int val) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == val) {
                return true;
            } else if (nums[mid] > val) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}