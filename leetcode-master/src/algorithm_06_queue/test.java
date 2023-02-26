package algorithm_06_queue;

import java.util.*;
class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        int tmp = stack1.pop();
        if (tmp == stack2.peek()){
            // System.out.println(stack1.peek());


            stack2.pop();
            System.out.println(stack2.peek());
        }
        // if(stack1.pop().equals(stack2.peek()))
        //     stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
public class test {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.min());

    }

}
