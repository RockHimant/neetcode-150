class Solution {
    public String minWindow(String s, String t) {   

      
        Map<Character, Integer> tMap = new HashMap();
        Map<Character, Integer> sMap = new HashMap();

        for(char ch: t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int required = tMap.size();
        int formed = 0;

        int i = 0;
        int j = 0;
        int[] ans = new int[]{-1, 0, 0};
        while (j < s.length()) {
            char ch = s.charAt(j);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            if (tMap.containsKey(ch) && tMap.get(ch) == sMap.get(ch)) {
                formed++;
            }

            while(i <= j && formed == required) {
                if (ans[0] == -1 || ans[0] > j - i + 1) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }

                ch = s.charAt(i);
                sMap.put(ch, sMap.get(ch) - 1);
                if (tMap.containsKey(ch) && sMap.get(ch) < tMap.get(ch)) {
                    formed--;
                }
                i++;
            }
              j++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
      
        
    }

}
