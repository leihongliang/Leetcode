package real.a;

/*
给定两个一元多项式以及多项式运算符，计算输出两个多项式运算的结果，计算规则见样例。
输入
分三行输入，第一行输入多项式A的系数数组(按照阶数高到低顺序)，第二行输入多项式B的系数数组，第三行输入多项式运算符运算符包括加(+)减(-]乘()三种，系数数组大小小于128，系数取值范围[-512,512]
输出
输出多项式运算结果的系数数组，如果计算后多项式为0，则输出0。从第1个非季的系数开始输出

输入:
[1 2 3 4 5 6]
[2 3 -4]
+
输出: [1 2 3 6 8 2]
解释: 多项式系数数组[1 2 3 4 5 6]表示多项式A=1x^5 + 2x4 + 3x^3 + 4x^2 + 5x + 6
多项式系数数组[2 3 -4]表示多项式B(x)=2x^2 + 3x - 4
A(x)+B(x)=1x^5 + 2x^4 + 3x^3 + 6x^2 +8x + 2，对应的多项式系数数组为[1 2 3 6 8 2]

输入:
[1 2 3]
[1 2 1]
-
输出: [2]
解释: (x^2 + 2x + 3) - (x2 + 2x + 1) = 2
高阶的0系数不输出
* */

import java.util.Arrays;
import java.util.Scanner;

public class huawei4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] aStr = sc.nextLine().replace("[", "").replace("]", "").split(" ");
        int[] a = new int[aStr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }
        String[] bStr = sc.nextLine().replace("[", "").replace("]", "").split(" ");
        int[] b = new int[bStr.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(bStr[i]);
        }
        char op = sc.nextLine().charAt(0);
        int[] result;
        switch (op) {
            case '+':
                result = add(a, b);
                break;
            case '-':
                result = subtract(a, b);
                break;
            case '*':
                result = multiply(a, b);
                break;
            default:
                result = null;
                break;
        }
        if (result != null) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("[");

            for (int i = 0; i < result.length; i++) {
                buffer.append(result[i]);
                if (i < result.length - 1) {
                    buffer.append(" ");
                }
            }
            buffer.append("]");
            System.out.println(buffer);
        }
    }


    public static int[] add(int[] a, int[] b) {
        int[] high, low;
        if (a.length >= b.length) {
            high = a;
            low = b;
        } else {
            high = b;
            low = a;
        }
        int[] result = new int[high.length];
        for (int i = 0; i < high.length; i++) {
            if (i < low.length) {
                result[i] = high[high.length - 1 - i] + low[low.length - 1 - i];
            } else {
                result[i] = high[high.length - 1 - i];
            }
        }
        reverse(result);
        result = removeLeadingZeros(result);
        return result;
    }

    public static int[] subtract(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = -b[i];
        }
        return add(a, b);
    }

    public static int[] multiply(int[] a, int[] b) {
        int[] result = new int[a.length + b.length - 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }
//        reverse(result);
        result = removeLeadingZeros(result);
        return result;
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int[] removeLeadingZeros(int[] arr) {
        if (arr.length == 0 || arr[0] != 0) {
            return arr;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            return new int[]{0};
        }
        int[] result = new int[arr.length - index];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[index + i];
        }
        return result;
    }

}
