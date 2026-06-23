class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int ans = 0;
        int maxF = 0;
        Map<Character, Integer> map = new HashMap();

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxF = Math.max(maxF, map.get(ch));

            if (r - l + 1 - maxF > k) {
                ch = s.charAt(l);
                map.put(ch, map.get(ch) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
        
    }
}
