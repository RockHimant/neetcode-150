

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (map.containsKey(ch) && map.get(ch) >= i) {
                i = map.get(ch) + 1;
            }

            map.put(ch, j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;


        }
        return maxLength;
    }
}
