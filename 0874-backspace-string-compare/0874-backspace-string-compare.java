class Solution {
    public boolean backspaceCompare(String s, String t) {

        //if(s.length() != t.length()) return false;

        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();

        int i=0; 
        int j=0;
        while(i < s.length() || j < t.length()){
            if(i< s.length()){
                if(!sbs.isEmpty() && s.charAt(i) == '#'){
                sbs.deleteCharAt(sbs.length()-1);
            }
                else if(s.charAt(i) != '#'){
                    sbs.append(s.charAt(i));
            }
          //  i++;
            }

            if(j < t.length()){
                if(!sbt.isEmpty() && t.charAt(i) == '#'){
                sbt.deleteCharAt(sbt.length()-1);
            }
                else if(t.charAt(j) != '#'){
                    sbt.append(t.charAt(i));
                }
                //j++;
            }
            i++;
            j++;
        }
        // System.out.println(sbs);
        // System.out.println(sbt);

        return sbs.toString().equals(sbt.toString());

    }
}