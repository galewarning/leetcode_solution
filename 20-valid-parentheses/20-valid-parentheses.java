class Solution {
    public boolean isValid(String s) {
        if(s == null) return true;
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            } else if(ch == '[') {
                stack.push(']');
            } else if(ch == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || ch != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}