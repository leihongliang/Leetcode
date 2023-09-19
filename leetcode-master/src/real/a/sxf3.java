package real.a;

import java.util.*;
/*
用java写一下这道题
现在存在交替次数n (n表示终端指纹至少交替多少次才算1个可信终端，比如上面的例子中交替1次即算1个可信终端，也可以是2或者3)，m组某个IP特定时间段内的指纹序列，请输出每组指纹对应的可信终端数量是多少?
输入描述
第一行输入两个正整数n，m
其中n表示终端指纹至少交替多少次才算1个可信终端，
接下来m行，每行输入某个IP的一组指纹序列。
输出描述
输出m行，每行一个整数，表示对应行可信终端数量的个数.
输入
3 1
EEBBAAGGEEBBAAGGEEBBAAGGEBAG
输出

4
* */

public class sxf3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        char prevChar = input.charAt(0);
        result.append(prevChar);

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar != prevChar) {
                result.append(currentChar);
                prevChar = currentChar;
            }
        }


        System.out.println(result.toString());
        scanner.close();
    }
}

