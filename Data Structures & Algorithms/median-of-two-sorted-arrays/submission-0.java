class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1+n2;
        int []newarr = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j <n2) {
            if (nums1[i] < nums2[j]) {
                newarr[k++] = nums1[i++];
            } else {
                newarr[k++] = nums2[j++];
            }
        }

        if (i < n1) {
            while (i < n1) {
                newarr[k++] = nums1[i++];
            }
        } 
        if (j < n2) {
            while (j < n2) {
                newarr[k++] = nums2[j++];
            }
        }

        if (n%2!=0) return newarr[n/2];
        else 
            return (float) (newarr[n/2] + newarr[n/2-1]) / 2;
        
    }
}
