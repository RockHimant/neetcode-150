class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if (anaMap.containsKey(newStr)) {
                anaMap.get(newStr).add(str);
            } else {
                List<String> list = new ArrayList();
                list.add(str);
                anaMap.put(newStr, list);
            }


        }

        List<List<String>> result = new ArrayList();

        for(List<String> vals : anaMap.values()) {
            result.add(vals);
        }
        return result;
    }
}
