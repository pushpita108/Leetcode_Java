class Solution {
    public int longestValidParentheses(String s) {
        
        int result = 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // so a valid stack is never empty
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) { // means we reached an empty ) so we push index
                    stack.push(i); // push 
                } else {
                    // always reaches because of -1 
                    // gives the length of the longest valid substring
                    result = Math.max(result, i - stack.peek()); // index - peek, to get rid of 'empty )' cases
                }
            }
        }
        return result;
    }
}