class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int r = Arrays.stream(piles).max().getAsInt();
        int l = 0;
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;
            int hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double) p / k);
            }

            if (hours <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
