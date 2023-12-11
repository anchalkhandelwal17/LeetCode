class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int left = 0;
        int right = arr.length/4;
        
        while(right < arr.length){
            
            if(arr[left] == arr[right]){
                return arr[left];
            }
            else{
                left++;
                right++;
            }
        }
        return -1;
    }
}