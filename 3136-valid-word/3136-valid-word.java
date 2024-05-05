class Solution {
    public boolean isValid(String word) {
        // TC : O(n) 
        // SC : O(1)
        if (word.length() < 3) {
            return false;
        }

        boolean flag1 = false;
        boolean flag2 = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (isVowel(ch)) {
                flag1 = true;
            }
            else if (Character.isLetter(ch)) {
                flag2 = true;
            }
        }

        return flag1 && flag2;
    }

    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}