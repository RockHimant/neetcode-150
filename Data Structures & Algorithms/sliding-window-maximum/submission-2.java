class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0;
        int j = 0;
        Deque<Integer> maxQueue = new LinkedList();
        int result[] = new int[nums.length - k +1];
        int index = 0;
        while(j < nums.length) {
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[j]) {
                maxQueue.pollLast();
            }

            maxQueue.offerLast(j);

            if (j - i + 1 < k) {
                j++;
            } else if (j- i +1 == k) {
                result[index++] = nums[maxQueue.peekFirst()];
                if(maxQueue.peekFirst() == i) {
                    maxQueue.pollFirst();
                }
                i++;
                j++;
            }
        }
        return result;
    }
}
