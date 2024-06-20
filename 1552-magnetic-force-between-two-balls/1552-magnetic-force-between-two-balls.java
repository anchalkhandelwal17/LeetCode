class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int ans = -1;
        int lo = 0;
        int hi = position[position.length-1];

        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(check(mid, position, m)){
                ans = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return ans;
    }
    public boolean check(int mid, int[] position, int m){
        --m;
        int i = 0;
        int lastPos = position[0];
        while(i < position.length){
            if(position[i] - lastPos >= mid){
                lastPos = position[i];
                 m--;
            }
            i++;
        }
        return m <= 0; 
    }
}
