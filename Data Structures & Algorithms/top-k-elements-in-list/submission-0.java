class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> []arr = new List[nums.length + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList();
        }
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        int []res = new int[k];

        int index = 0;
        for (int i = arr.length -1; i> 0 && index <k; i--) {
            for(int n: arr[i]) {
                res[index++] = n;

                if(index == k) {
                    return res;
                }
            }
        }
        return res;
        
    }
}
