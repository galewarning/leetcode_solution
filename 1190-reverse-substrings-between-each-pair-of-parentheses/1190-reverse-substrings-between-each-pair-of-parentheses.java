class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> dq = new ArrayDeque<>();
        dq.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.push(new StringBuilder());
            } else if (s.charAt(i) == ')') {
                StringBuilder temp = dq.pop().reverse();
                dq.peek().append(temp);
            } else {
                dq.peek().append(s.charAt(i));
            }
        }
        return dq.pop().toString();
    }
}