package bl;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 7/11/2019.
 *
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

 */
public class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private PriorityQueue<Integer> min ;

    public MinStack() {
        stack = new Stack<>();
        min =  new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        min.add(x);
    }

    public void pop() {
        int pop = stack.pop();
        min.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}