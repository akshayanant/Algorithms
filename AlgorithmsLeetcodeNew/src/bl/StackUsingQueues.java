package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 8/29/2019.
 */
class MyStack {

    /** Initialize your data structure here. */
    private  List<Integer> queue;
    public MyStack() {
        queue = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(0,x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove(0);
    }

    /** Get the top element. */
    public int top() {
        return queue.get(0);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
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
