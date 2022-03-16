class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums1) {
            set.add(i);
        }
        
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        
        int[] resArr = new int[res.size()];
        int index = 0;
        for (int i : res) {
            resArr[index++] = i;
        }
        
        return resArr;
    }
}