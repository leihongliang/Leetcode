package algorithm_06_queue;
import java.util.Deque;
import java.util.LinkedList;

public class e150逆波兰表达式求值 {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (s.equals("-")) {
                int tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            }else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() /tmp);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}
