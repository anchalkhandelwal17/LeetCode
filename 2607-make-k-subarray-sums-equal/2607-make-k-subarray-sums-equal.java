class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        // TC : O(klogk)
        // SC : O(k*k)
        k = gcd(arr.length, k);
        long ans = 0;
        for(int i=0; i<k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            for(int j=i; j<arr.length; j+=k){
                list.add(arr[j]);
            }
            Collections.sort(list);

            int median = list.get(list.size()/2);

            for(int j=0; j<list.size(); j++){
                ans = ans + (Math.abs(list.get(j) - median));
            }
        }
        return ans;
    }

    public int gcd(int x, int y){
        while(y != 0){
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}