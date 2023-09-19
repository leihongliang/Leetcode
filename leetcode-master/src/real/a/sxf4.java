package real.a;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;
/*

一家电子商务公司出售各种字母形状的挂件。挂件按照其字母顺序被压入一个库存栈中。在入栈的任意过程中，允许库存中的字母挂件被出售（即出栈）。
例如，如果字母序列是abc，那么可能的出售顺序包括abc、acb、bac、bca、cab、cba等。请编写一个程序，输入一个字母序列，输出所有可能的出售顺序。
输入描述
字符串，如：abc
输出描述
可能的出栈顺序，每行一种顺序
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入

abc
输出
abc
acb
bac
bca
cba
* */

public class sxf4 {
    static List<Deque<Character>> res = new ArrayList<>();

    public static void printOut(Deque<Character> q) {
        while (!q.isEmpty()) {
            System.out.print(q.peek());
            q.pop();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Deque<Character> qValues = new ArrayDeque<>();
        Deque<Character> qOutput = new ArrayDeque<>();
        Stack<Character> sTemp = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            qValues.add(str.charAt(i));
        }
        findAllSequences(qValues, sTemp, qOutput, str.length());
        for (int j = res.size() - 1; j >= 0; j--) {
            printOut(res.get(j));
        }
    }

    public static void findAllSequences(Deque<Character> qValues, Stack<Character> sTemp, Deque<Character> qOutput, int size) {
        if (qValues.isEmpty() && sTemp.isEmpty() && qOutput.size() == size) {
            res.add(new ArrayDeque<>(qOutput));
            return;
        }
        if (!qValues.isEmpty()) {
            char c = qValues.peek();
            sTemp.push(c);
            qValues.pop();
            findAllSequences(qValues, sTemp, qOutput, size);
            sTemp.pop();
            qValues.push(c);
        }
        if (!sTemp.isEmpty()) {
            char c = sTemp.peek();
            sTemp.pop();
            qOutput.add(c);
            findAllSequences(qValues, sTemp, qOutput, size);
            qOutput.removeLast();
            sTemp.push(c);
        }
    }


}
