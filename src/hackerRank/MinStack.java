/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 *
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack {
	 /** initialize your data structure here. */
	Stack<Integer> stack; // To avoid two stack you can also store the difference of incoming element and min. element and return the top + min when pop() is called.
	Stack<Integer> helper;
    public MinStack() {
    	stack = new Stack<>();
    	helper = new Stack<>();
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(helper.isEmpty() || helper.peek() >  x)
    		helper.push(x);
    	else
    		helper.push(helper.peek());
        
    }
    
    public void pop() {
        stack.pop();
        helper.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
    	return helper.peek();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
