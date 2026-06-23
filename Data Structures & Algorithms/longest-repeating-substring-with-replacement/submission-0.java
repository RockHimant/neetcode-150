class Solution {
    public int characterReplacement(String s, int k) { 
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap();
        int maxF = 0;
        for(int right= 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxF = Math.max(maxF, map.get(ch));

            if (right-left+1 - maxF > k) {
                ch = s.charAt(left);
                map.put(ch, map.get(ch)-1);
                left++;
            }
            res = Math.max(res, right - left + 1);

        }
        return res;
        
    }
}
