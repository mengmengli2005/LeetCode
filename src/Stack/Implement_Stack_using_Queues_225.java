package Stack;

import java.util.LinkedList;

public class Implement_Stack_using_Queues_225 {
    LinkedList<Integer> queue;
    LinkedList<Integer> tmp;
    int top = Integer.MAX_VALUE;
    /** Initialize your data structure here. */
    public Implement_Stack_using_Queues_225() {
        queue = new LinkedList<>();
        tmp = new LinkedList<>();
        top = Integer.MAX_VALUE;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addFirst(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.size() == 0) return Integer.MIN_VALUE;
        while (queue.size() > 1) {
            int p = queue.removeLast();
            tmp.addFirst(p);
        }
        int pop = queue.removeLast();
        queue = tmp;
        if (queue.size() != 0) {
            top = queue.getFirst();
        } else top = Integer.MAX_VALUE;
        tmp = new LinkedList<>();
        return pop;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }

    public static void main(String[] args) {
        Implement_Stack_using_Queues_225 Q = new Implement_Stack_using_Queues_225();
        Q.push(1);
        Q.push(2);
        Q.push(3);
        Q.push(4);
        Q.push(5);

        System.out.println(Q.pop());
        System.out.println(Q.pop());
        System.out.println(Q.pop());
        System.out.println(Q.pop());
        System.out.println(Q.top());
        System.out.println(Q.pop());
        System.out.println(Q.empty());
    }
}
