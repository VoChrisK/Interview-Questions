/*
    Leetcode #20 - https://leetcode.com/problems/valid-parentheses/
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(stack.empty() || c + stack.pop() != 81) return false;
            } else if(c == ']') {
                if(stack.empty() || c + stack.pop() != 184) return false;
            } else if(c == '}') {
                if(stack.empty() || c + stack.pop() != 248) return false;
            } else {
                stack.push(c);
            }
        }
        
        return stack.empty();
    }
}