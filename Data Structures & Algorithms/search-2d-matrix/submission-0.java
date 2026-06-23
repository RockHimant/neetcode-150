class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top = 0;
        int bot = matrix.length -1 ;
        int n = matrix[0].length-1;

        while (top <= bot) {
            int row = (bot + top) /2;

            if (target > matrix[row][n]) {
                top++;
            } else if (target < matrix[row][0]) {
                bot--;
            } else {
                break;
            }

        }

        if (! (top <= bot)) {
            return false;
        }
        int row = (bot + top) / 2;
        int l = 0;
        int r = n;
    
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
        
    }

    
}
