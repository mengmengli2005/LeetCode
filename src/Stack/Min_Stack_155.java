package Stack;

import java.util.Stack;

public class Min_Stack_155 {
    // Method 1: using java Stack data structure.
    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

//    public Min_Stack_155() {
//        Stack<Integer> stack = new Stack<>();
//        int min = Integer.MAX_VALUE;
//    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        }
        else stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Min_Stack_155 M = new Min_Stack_155();
        M.push(-2);
        M.push(0);
        M.push(-3);
        int min1 = M.getMin();
        System.out.println("the first min value is: " + min1);
        M.pop();
        M.pop();
        int min2 = M.getMin();
        System.out.println("the second min value is: " + min2);
    }

}
