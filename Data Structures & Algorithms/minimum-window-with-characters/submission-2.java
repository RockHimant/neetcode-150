class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        
        int ans[] = new int[] {-1, 0, 0};
        Map<Character, Integer> tMap = new HashMap();
        Map<Character, Integer> sMap = new HashMap();
        for(char ch: t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int required = tMap.size();
        int formed = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            sMap.put(ch, sMap.getOrDefault(ch,0) +1);

            if (tMap.containsKey(ch) && tMap.get(ch).intValue() == sMap.get(ch).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                if (ans[0] == -1 || ans[0] > r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                ch = s.charAt(l);
                sMap.put(ch, sMap.get(ch)-1);
                if (tMap.containsKey(ch) && sMap.get(ch) < tMap.get(ch)) {
                    formed--;
                }
                l++;
            }



        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}
