class Solution {

    int[] array;
    int[] original;
    Random rand = new Random();
    
    public Solution(int[] nums) {
        original = nums.clone();
        array = nums;
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        
        
        for (int i = 0; i < original.length; i++) {
            int nextInt = rand.nextInt(list.size());
            array[i] = list.get(nextInt);
            list.remove(nextInt);
        }
        
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */