class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int n = boxTypes.length;
        int maxUnits = 0;
        for(int i=0; i<n; i++){
            int a = boxTypes[i][0];
            int b = boxTypes[i][1];
            if(truckSize >= a){
                maxUnits = maxUnits + (b * a);
                truckSize -= a;
            }
            else{
                maxUnits = maxUnits + (truckSize * b);
                break;
            }
        }
        return maxUnits;
    }
}