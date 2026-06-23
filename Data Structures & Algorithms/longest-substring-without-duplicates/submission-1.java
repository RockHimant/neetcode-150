class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap();
        while(right < s.length()) {
            char ch = s.charAt(right);
            
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch)+1;
            }

            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;

        }

        return maxLength;
        
    }
}
