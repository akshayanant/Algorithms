package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 10/16/2019.
 */
public class ReverseStack {
    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack,temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack,x);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        new ReverseStack().reverse(stack);
        System.out.println(stack);
    }
}
