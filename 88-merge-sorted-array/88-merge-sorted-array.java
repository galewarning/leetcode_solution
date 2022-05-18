class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int tail = m + n - 1;
        while (tail2 >= 0) {
            if (tail1 >= 0 && nums1[tail1] > nums2[tail2]) {
                nums1[tail--] = nums1[tail1--];
            } else {
                nums1[tail--] = nums2[tail2--];
            }
        }
    }
}