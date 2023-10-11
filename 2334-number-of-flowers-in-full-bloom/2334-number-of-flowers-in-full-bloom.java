class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int m = flowers.length;
        int[] answer = new int[n];
        int[] bloomedArr = new int[m];
        int[] diedArr = new int[m];

        for(int i=0; i<m; i++){
            bloomedArr[i] = flowers[i][0];
            diedArr[i] = flowers[i][1];
        }
        Arrays.sort(bloomedArr);
        Arrays.sort(diedArr);

        for(int i=0; i<n; i++){
            int bloomed = upperBound(bloomedArr, people[i]);
            int died = lowerBound(diedArr, people[i]);
            answer[i] = bloomed - died;
        }
        return answer;
    }

    public int upperBound(int[] nums, int num){
        int start = 0;
        int end = nums.length-1;
        int res = -1;

        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] > num){
                res = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res == -1 ? nums.length : res;
    }

    public int lowerBound(int[] nums, int num){
        int start = 0;
        int end = nums.length-1;
        int res = -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] < num){
                start = mid+1;
            }
            else{
                res = mid;
                end = mid-1;
            }
        }
        return res == -1 ? nums.length :  res;
    }
}