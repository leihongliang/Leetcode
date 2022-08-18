package algorithm_06_queue;

import java.util.ArrayDeque;
import java.util.Stack;
public class e1047删除字符串中的所有相邻重复项 {

    //1 stack方法
    public static String removeDuplicates(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char cur = s.charAt(i);
            if (stack.peek().equals(cur)) {
                stack.pop();
                continue;
            }else {
                stack.push(cur);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    //1 stack方法
    public static String removeDuplicates1(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty() || !stack.peek().equals(cur)) {
                stack.push(cur);
            }else {
                stack.pop();
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }


    // 1.1stack 换成deque 这个方法最优
    public static String removeDuplicates2(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != cur) {
                deque.push(cur);
            }else {
                deque.pop();
            }
        }
        String res = "";
        while (!deque.isEmpty()) {
            res = deque.pop() + res;
        }
        return res;
    }


    //stringbuffer
    public static String removeDuplicates3(String s) {
        StringBuffer sb = new StringBuffer();
        int top = -1;// 代表sb为空
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // 不为空且相同
            if (top >= 0 && sb.charAt(top) == cur) {
                sb.deleteCharAt(top);
                top--;
            }else {
                sb.append(cur);
                top++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates3(s));
    }
}

