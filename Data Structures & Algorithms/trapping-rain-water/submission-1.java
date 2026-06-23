class Solution {
    public int trap(int[] height) {

        int l = 0;
        int r = height.length-1;
        int maxWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (l < r) {
            if(height[l] < height[r]) {
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    maxWater += leftMax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];

                } else {
                    maxWater += rightMax - height[r];
                }
                r--;
            }
        }

        return maxWater;
       
    }
}
