class Solution {
    public int calculate(String s) {
        int currentNumber = 0;
        char lastOp = '+';
        char c;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                c = '+';
            } else {
                c = s.charAt(i);
            }
            if (c == ' ') continue;
            if (c <= '9' && c >= '0') {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (lastOp == '+') {
                stack.push(currentNumber);
                currentNumber = 0;
                lastOp = c;
            } else if (lastOp == '-') {
                stack.push(-currentNumber);
                currentNumber = 0;
                lastOp = c;
            } else if (lastOp == '*') {
                stack.push(stack.pop() * currentNumber);
                currentNumber = 0;
                lastOp = c;
            } else if (lastOp == '/') {
                stack.push(stack.pop() / currentNumber);
                currentNumber = 0;
                lastOp = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res = res + stack.pop();
        }
        return res;
    }
}