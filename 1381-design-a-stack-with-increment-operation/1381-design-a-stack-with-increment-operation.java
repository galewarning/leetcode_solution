/*class CustomStack {
    int[] l;
    int maxSize;
    int size;

    public CustomStack(int maxSize) {
        this.l = new int[maxSize];
        this.size = -1;
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (size < this.maxSize - 1) {
            size++;
            l[size] = x;
        }
    }
    
    public int pop() {
        if (this.size == -1) {
            return -1;
        }
        int a = l[size];
        l[size] = 0;
        size--;
        return a;
    }
    
    public void increment(int k, int val) {
        int m = Math.min(k, this.size + 1);
        for (int i = 0; i < m; i++) {
            l[i] += val;
        }
    }
}
*/
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
class CustomStack {
    private int[] stack;
    private int[] increment;
    private int size;
    
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.size = 0;
    }
    
    public void push(int x) {
        if(this.size < this.stack.length)
            this.stack[this.size++] = x;
    }
    
    public int pop() {
        if(this.size < 1)
            return -1;
        
        if(--this.size > 0)
            this.increment[this.size - 1] += this.increment[this.size];
        
        int result = this.stack[this.size] + this.increment[this.size];
        
        this.increment[this.size] = 0;
        
        return result;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k, this.size) - 1;
        
        if(i > -1)
            this.increment[i] += val;
    }
}