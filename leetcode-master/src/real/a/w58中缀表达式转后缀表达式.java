package real.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
从存储系统中拉取数据的时候，经常需要加⼀些过滤条件来获取想要的数据, 因此很多存储系统都⽀持过滤器功能。假设某存储系统⽀持与或⾮三种过滤逻辑以及括号，业务拉取数据的时候只需要输⼊过滤字符串就可以实现数据过滤拉取。 为了⽅便的处理运算符的优先级，通常需要把⽤户输⼊的过滤字符串(中缀表达式)转化成后缀表达式并输出，请写⼀个程序实现上述功能。

逻辑符号定义:
逻辑与&
逻辑或|
逻辑⾮!
左括号(, 右括号), 左右括号需要配合使⽤
优先级:
() > ! > & > |

示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
"exp1 & (exp2 | exp3) | !exp4"
输出
复制
"exp1 exp2 exp3 | & exp4 ! |"
* */
public class w58中缀表达式转后缀表达式 {
    // 定义运算符的优先级
    // 定义逻辑符号和优先级
    private static final String AND = "&";
    private static final String OR = "|";
    private static final String NOT = "!";
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final int PRIORITY_AND = 1;
    private static final int PRIORITY_OR = 0;
    private static final int PRIORITY_NOT = 2;
    private static final int PRIORITY_BRACKET = -1;

    // 判断一个字符是否是逻辑符号
    private static boolean isLogicSymbol(char c) {
        return c == '&' || c == '|' || c == '!' || c == '(' || c == ')';
    }

    // 获取一个逻辑符号的优先级
    private static int getPriority(String symbol) {
        switch (symbol) {
            case AND:
                return PRIORITY_AND;
            case OR:
                return PRIORITY_OR;
            case NOT:
                return PRIORITY_NOT;
            case LEFT_BRACKET:
            case RIGHT_BRACKET:
                return PRIORITY_BRACKET;
            default:
                throw new IllegalArgumentException("Invalid logic symbol: " + symbol);
        }
    }

    // 将中缀表达式转换为后缀表达式
    public static String convertInfix2Postfix(String exprStr) {
        // 使用一个栈来存储逻辑符号
        Stack<String> stack = new Stack<>();
        // 使用一个字符串缓冲区来存储后缀表达式
        StringBuilder postfix = new StringBuilder();
        // 遍历中缀表达式的每个字符
        for (int i = 0; i < exprStr.length(); i++) {
            char c = exprStr.charAt(i);
            if (isLogicSymbol(c)) {
                // 如果是逻辑符号，先判断是否是左括号或栈为空，如果是则直接入栈
                if (c == '(' || stack.isEmpty()) {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    // 如果是右括号，就弹出栈顶元素并追加到后缀表达式，直到遇到左括号或栈为空
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    // 如果栈不为空，就弹出左括号
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    // 如果是其他逻辑符号，就比较它和栈顶元素的优先级
                    // 如果当前符号的优先级小于等于栈顶符号，就弹出栈顶元素并追加到后缀表达式，直到遇到优先级更低的或栈为空
                    while (!stack.isEmpty() && getPriority(String.valueOf(c)) <= getPriority(stack.peek())) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    // 然后将当前符号入栈
                    stack.push(String.valueOf(c));
                }
            } else {
                // 如果不是逻辑符号，就直接追加到后缀表达式
                postfix.append(c);
            }
        }
        // 遍历完中缀表达式后，将栈中剩余的逻辑符号依次弹出并追加到后缀表达式
        while (!stack.isEmpty()) {
            postfix.append(" ").append(stack.pop());
        }
        // 返回后缀表达式字符串
        return postfix.toString();
    }

    public static void main(String[] args) {
        // 测试示例
        String infix = "exp1 & (exp2 | exp3) | !exp4";
        String postfix = convertInfix2Postfix(infix);
        System.out.println(postfix); // exp1 exp2 exp3 | & exp4 ! |
    }
}
