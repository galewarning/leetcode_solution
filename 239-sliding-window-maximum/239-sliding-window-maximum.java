class MyQueue {
    Deque<Integer> dq = new LinkedList<>();
    
    public void poll(int val) {
        if (!dq.isEmpty() && val == dq.peek()) {
            dq.poll();
        }
    }
    
    //remove all the value which value < val
    public void add(int val) {
        while (!dq.isEmpty() && val > dq.getLast()) {
            dq.removeLast();
        }
        dq.add(val);
    }
    
    //return the largest value
    public int peek() {
        return dq.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue mq = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        
        for (int i = 0; i < k; i++) {
            mq.add(nums[i]);
        }
        res[index++] = mq.peek();
        
        for (int i = k; i < nums.length; i++) {
            mq.add(nums[i]);
            mq.poll(nums[i - k]);
            res[index++] = mq.peek();
        }
        
        return res;
    }
}