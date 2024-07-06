class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        // int[] arr = new int[n * 2];
        // for(int i=0; i<n; i++){
        //     arr[i] = colors[i];
        //     // arr[n*2-i-1] = colors[i];
        //     arr[n+i] = colors[i];
        // }
        // int cnt = 0;
        // for(int i=1; i<arr.length-2; i++){
        //     if(arr[i] != arr[i-1] && arr[i] != arr[i+1]){
        //         cnt++;
        //     }
        // }
        // System.out.println(Arrays.toString(arr));
        // return cnt;
        int cnt = 0;
        for(int i=1; i<n-1; i++){
            if(colors[i] != colors[i-1] && colors[i] != colors[i+1]){
                cnt++;
            }
        }
        if(colors[n-2] != colors[n-1] && colors[n-2] == colors[0]) cnt++;
        if(colors[n-1] != colors[0] && colors[n-1] == colors[1]) cnt++;
        return cnt;
    }
}