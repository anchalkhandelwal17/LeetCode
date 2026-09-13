class Solution {
    static List<Integer> odd = new ArrayList<>();
    static List<Integer> even = new ArrayList<>();

    static int max = (int)(1e9);

    public static long numMirror(int x, boolean flag){

        long val = x;
        if(flag) x/=10;

        while(x > 0){
            int rem = x % 10;
            val = val * 10 + rem;
            x /= 10;
        }

        return val;
    }

    public static void generatePalin(){

        for(int i=1; i<=99999; i++){
            long a = numMirror(i, true);

            if(a <= max){
                if(a % 2 == 0) even.add((int)a);
                else odd.add((int)a);
            }

            long b = numMirror(i, false);

            if(b <= max){
                if(b % 2 == 0) even.add((int)b);
                else odd.add((int)b);
            }
        }

        Collections.sort(odd);
        Collections.sort(even);
    }

    static {
        generatePalin();
    }

    public long minOperations(int[] nums) {
        long ans = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            long res = Long.MAX_VALUE;
            int num = nums[i];
            List<Integer> palins;
            if(num % 2 == 0){
                palins = even;
            }
            else palins = odd;

            int getPalin = lb(palins, num);

            if(getPalin > 0){
                res = Math.min(res, (num - palins.get(getPalin - 1)) / 2);
            }
            if(getPalin < palins.size()){
                res = Math.min(res, (palins.get(getPalin) - num) / 2);
            }

            ans += res;
        }
        return ans;
    }

    public int lb(List<Integer> list, int target){
        int lo = 0;
        int hi = list.size()-1;
        int ans = list.size();

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(list.get(mid) >= target){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }

        return ans;
    }
}