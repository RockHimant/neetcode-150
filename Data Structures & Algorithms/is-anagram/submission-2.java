class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> sMap = new HashMap();

        for(char ch: s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch , 0) + 1);
        }

        for(char ch: t.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch , 0) - 1);
        }

        for (int val : sMap.values()) {
            if (val != 0) return false;
            
        }

        return true;

    }
}
