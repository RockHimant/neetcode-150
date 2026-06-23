class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int l = 0;
        int r = 0;
        Deque<Integer> dqueue = new LinkedList();
        int []res = new int[nums.length - k + 1];
        int index = 0;
        while (r < nums.length) {
            while(!dqueue.isEmpty() && nums[dqueue.peekLast()] < nums[r]) {
                dqueue.pollLast();
            }
            dqueue.offerLast(r);

            if (r - l + 1 == k) {
                if (dqueue.isEmpty()) {
                    res[index++] = 0;
                } else {
                    res[index++] = nums[dqueue.peekFirst()];
                    if (dqueue.peekFirst() == l) {
                        dqueue.pollFirst();
                        
                    }
                    l++; r++;
                }
                
            } else if (r - l + 1 < k) {
                r++;
            }
            
        }
        return res;

        
    }
}
