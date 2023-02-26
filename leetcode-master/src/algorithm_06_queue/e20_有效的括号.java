package algorithm_06_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class e20_有效的括号 {
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length()%2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '{' || cur == '[' || cur == '(' || stack.isEmpty()) {
                stack.push(cur);
            }
            if (cur == '}' ) {
                if (stack.pop() != '{') return false;
            }
            if (cur == ']' ) {
                if (stack.pop() != '[') return false;
            }
            if (cur == ')' ) {
                if (stack.pop() != '(') return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }else {
            return true;
        }

    }
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length()%2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '{') {
                stack.push('}');
            }else if (cur == '[') {
                stack.push(']');
            }else if (cur == '(') {
                stack.push(')');
            }else if (stack.isEmpty() || cur != stack.pop() ) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValid3(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.pop() != ch) {
                return false;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "}}";
        System.out.println(isValid2(s));
    }
}

