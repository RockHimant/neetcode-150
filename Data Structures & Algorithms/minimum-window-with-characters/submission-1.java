class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int ans[] = new int[]{-1, 0, 0};

        Map<Character, Integer> patMap = new HashMap();
        for(char ch: t.toCharArray()) {
            patMap.put(ch, patMap.getOrDefault(ch, 0) + 1);
        }

        int required = patMap.size();
        int formed =0 ;
        Map<Character, Integer> charMap = new HashMap();
        while (right < s.length()) {
            char ch = s.charAt(right);
            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);

            if (patMap.containsKey(ch) && patMap.get(ch).intValue() == charMap.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                ch = s.charAt(left);
                charMap.put(ch, charMap.get(ch)-1);
                if (patMap.containsKey(ch) && charMap.get(ch) < patMap.get(ch)) {
                    formed--;
                }
                left++;
            }
            
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);

        
    }
}
