class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;

        while (l < r) {
            while(l < r && !isAlphaNumeric(s.charAt(l))) {
                l++;
            }

            while (r > l && !isAlphaNumeric(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
        
        
    }

    public boolean isAlphaNumeric(char ch) {
        return (ch <= 'Z' && ch >= 'A' || ch <= 'z' && ch >= 'a' || ch <= '9'&& ch >= '0');
    }
}
