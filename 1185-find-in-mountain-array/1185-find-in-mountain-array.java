/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length(); 
        if(length < 3){
            return -1;
        }

        int peak = findPeak(mountainArr, length);

        int idx = findTarget(mountainArr, 0, peak, target, true);
        if(idx != -1) return idx;
        return findTarget(mountainArr, peak+1, length-1, target, false);      
    }

    public int findTarget(MountainArray mountainArr, int start, int end, int target, boolean flag){

        while(start <= end){

            int mid = (start + end)/2;

            int midVal = mountainArr.get(mid);
            
            if(midVal == target){
                return mid;
            }
            if(flag){
                if(midVal > target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(midVal > target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public int findPeak(MountainArray mountainArr, int length){

        int start = 0;
        int end = length-1;

        while(start < end){
            int mid = (start + end)/2;

            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}