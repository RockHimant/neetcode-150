class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList();
        Map<String, List<String>> strMap = new HashMap();
        for (String str : strs) {
             char[] chars = str.toCharArray();
             Arrays.sort(chars);
             String newStr = new String(chars);
             if (strMap.containsKey(newStr)) {
                strMap.get(newStr).add(str);
             } else {
                List<String> list = new ArrayList();
                list.add(str);
                strMap.put(newStr, list);
             }
        }
        for (List<String> list : strMap.values()) {
            result.add(list);
        }

        return result;
    }
}
