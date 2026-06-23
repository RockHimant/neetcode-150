class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> charMap = new HashMap();

        for (char ch: s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch: t.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) -1);
        }

        for (int value: charMap.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;

    }
}
