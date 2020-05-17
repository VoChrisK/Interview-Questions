/**
 * 
 * Leetcode #155 - https://leetcode.com/problems/min-stack/
 */

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> normalStack;
    Stack<Integer> minStack;

    public MinStack() {
        normalStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        normalStack.push(x);
        if (x <= normalStack.peek() && (minStack.empty() || x <= minStack.peek())) {
            minStack.push(x);
        }
    }

    public void pop() {
        int popped = normalStack.pop();
        if (!minStack.empty() && popped == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */