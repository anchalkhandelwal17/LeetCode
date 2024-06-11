class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // TC : O(nlogn)
        // SC : O(n)
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = arr1.length;
        for(int i=0; i<n; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
        }

        int m = arr2.length;
        int j = 0;

        for(int i=0; i<m; i++){
            if(map.containsKey(arr2[i])){
                while(map.get(arr2[i]) > 0){
                    arr1[j++] = arr2[i];
                    map.put(arr2[i], map.getOrDefault(arr2[i], 0)-1);
                }
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) == 0) continue;
            for(int i=0; i<map.get(key); i++){
                arr1[j++] = key;
            }
        }
        return arr1;
    }
}