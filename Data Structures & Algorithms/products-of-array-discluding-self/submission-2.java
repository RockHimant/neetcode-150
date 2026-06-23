class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] prefix = new int[nums.length+1];
        prefix[0] = 1;
        for (int i = 1 ;i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int [] postfix = new int[nums.length + 1];
        postfix[nums.length-1] = 1;
        for (int i = nums.length- 2; i>=0; i--) {
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        int [] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
        
    }
}  
