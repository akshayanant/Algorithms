package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 10/19/2019.
 */
public class MaxStack {
    class MaxNodeStack{
        int val;
        int max;
        public MaxNodeStack(int val, int max){
            this.val = val;
            this.max = max;
        }
    }

    private Stack<MaxNodeStack> stack;
    private int max;
    public MaxStack(){
        stack = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int val){
        max = Math.max(max,val);
        MaxNodeStack node = new MaxNodeStack(val,max);
        stack.push(node);
    }

    public int pop(){
        MaxNodeStack node = stack.pop();
        max = stack.isEmpty()?Integer.MIN_VALUE:stack.peek().max;
        return node.val;
    }

    public int max(){
        return max;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        maxStack.push(4);
        System.out.println(maxStack.max());
        maxStack.pop();
        System.out.println(maxStack.max());
        maxStack.push(2);
        System.out.println(maxStack.max());
    }
}
