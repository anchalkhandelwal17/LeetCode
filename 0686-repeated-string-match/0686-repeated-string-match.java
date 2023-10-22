class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(cnt=1; sb.length() <= b.length(); cnt++){
            sb.append(a);
            if(sb.toString().contains(b)){
                return cnt;
            }
        }
        if(sb.append(a).toString().contains(b)){
            return cnt;
        }
        return -1;
    }
}