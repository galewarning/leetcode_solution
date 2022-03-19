class MyStack {
    
    Queue<Integer> queue1; 
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.poll();
        while (queue2.size() > 0) {
            queue1.offer(queue2.poll());
        }
        return res;
    }
    
    public int top() {
        int res = this.pop();
        this.push(res);
        return res;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */