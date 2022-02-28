class Solution {
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
    
    /*public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
            }
        }
        return res;
    }*/
    
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}