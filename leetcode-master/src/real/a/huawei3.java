package real.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
设计一款计算器软件，支持以下功能：
1）支持let关键字

2）支持通过let赋值表达式定义变量并初始化
例如：
let var1 = 123
let var=123

3）变量需要先定义再引用，在表达式中引用未定义的变量，则表达式的结果也是未定义的
例如：
let var1 = 1
let var2 = var1 + 1 // var1是定义的
let var3 = var4 + 1 // var4是未定义的
let var4 = 1

4）支持整数类型数据，整数数据的输入格式只需要支持十进制，支持负整数，整数取值范围-2147483648 <= x <= 2147483647
例如：
let var3 = 10
let var3 = -10

5）支持整数的加(+)、减(-)、乘(*)、除(/)四则运算，四则运算符之间没有优先级，运算数遵循左结合律，用例不考虑括号
例如：
let var4 = 1 + 2 * var3
上述表达式的计算顺序是，先计算1+2结果为3，再将3乘以var3得到表达式的结果。

6）支持通过out函数打印变量的值，函数参数只接受1个变量，不需要支持表达式
例如：
let var4 = 12
out(var4) // 将会输出12

7）表达式中如果引用了未定义的变量，则表达式的结果是未定义的
8）如果计算结果溢出，则表达式结果是溢出

9）变量命名符合通用语言变量规范，必须是以下划线(_)或者字母开头，遇到标点符号或者空格符时结束
例如：
let _ = 1 // 变量名_是合法的
let _abc = 1 // 合法
let abc = 1 // 合法
let Abc_1 = 1 // 合法
let abc.x = 1 // 非法
let abc,x = 1 // 非法
let 12abc = 1 // 非法
let abc x = 1 // 非法

输入
输入描述
1）每一行只有一个表达式
2）最多支持24行输入
3）每个用例输入至少有一个out输出表达式，可以有多个out输出表达书
4）每个变量只会赋值1次
例如：
let var1 = 1
let var2 = 3
let var3 = var1 + var2
out(var3)

输出
输出描述
1）每遇到1个out输出表达式，则打印输出变量的值
2）对于out行，只会输出一个out表达式的值
3）如果out输出的变量未定义，则打印<undefined>
4）如果表达式结果发生了整数上溢或者下溢，则对该变量的out输出表达式输出<underflow>或者<overflow>
5）如果表达式非法，则打印<syntax-error>
例如：
给定输入
let var1 = 1
let var2 = 3
let var3 = var1 + var2
out(var3)
out(var2)
out(var)
let var4 = -2147483649
let var5 = 2147483648
out(var4)
out(var5)
let x.y = 1
输出为
4
3
<undefined>
<underflow>
<overflow>
<syntax-error>

样例1
输入：
let var1 = 1
out(var1)
输出：
1

样例3
输入
let var1 = 1
let var2 = 3
let var3 = var1 + var2
out(var3)
输出：
3

样例2
输入：
out(var)
输出：
<undefined>
解释：
输出的变量var未定义
* */




import java.util.HashMap;
import java.util.Scanner;




import java.util.*;

import java.util.HashMap; import java.util.Scanner;

public class huawei3 { // 定义一个哈希表存储变量名和值的映射 private static HashMap<String, Integer> variables = new HashMap<>();
    private static HashMap<String, Integer> variables = new HashMap<>();
    // 定义一个方法判断一个字符串是否是合法的变量名
    private static boolean isVariable(String s) {
        if (s == null || s.length() == 0) return false;
        char first = s.charAt(0);
        if (first != '_' && !Character.isLetter(first)) return false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '_' || Character.isLetterOrDigit(c)) continue;
            else return false;
        }
        return true;
    }

    // 定义一个方法判断一个字符串是否是合法的整数
    private static boolean isInteger(String s) {
        if (s == null || s.length() == 0) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 定义一个方法计算一个表达式的值，如果表达式非法或者发生溢出，则返回null
    private static Integer evaluate(String expression) {
        if (expression == null || expression.length() == 0) return null;
        String[] tokens = expression.split(" "); // 按空格分割表达式
        Integer result = null; // 存储计算结果
        char operator = '+'; // 存储当前运算符，默认为加法
        for (String token : tokens) {
            if (isInteger(token)) { // 如果是整数，则直接参与运算
                int num = Integer.parseInt(token);
                switch (operator) {
                    case '+':
                        if (result == null) result = num; // 如果是第一个数，则直接赋值给结果
                        else result += num; // 否则执行加法运算
                        break;
                    case '-':
                        if (result == null) result = -num; // 如果是第一个数，则直接赋值给结果的相反数
                        else result -= num; // 否则执行减法运算
                        break;
                    case '*':
                        if (result == null) result = num; // 如果是第一个数，则直接赋值给结果
                        else result *= num; // 否则执行乘法运算
                        break;
                    case '/':
                        if (result == null || num == 0) return null; // 如果是第一个数或者除数为0，则返回null
                        else result /= num; // 否则执行除法运算
                        break;
                    default:
                        return null; // 如果运算符不合法，则返回null
                }
            } else if (isVariable(token)) { // 如果是变量，则先查找其值，再参与运算
                Integer value = variables.get(token); // 获取变量的值，如果未定义，则为null
                if (value == null) return null; // 如果变量未定义，则返回null
                switch (operator) {
                    case '+':
                        if (result == null) result = value; // 如果是第一个数，则直接赋值给结果
                        else result += value; // 否则执行加法运算
                        break;
                    case '-':
                        if (result == null) result = -value; // 如果是第一个数，则直接赋值给结果的相反数
                        else result -= value; // 否则执行减法运算
                        break;
                    case '*':
                        if (result == null) result = value; // 如果是第一个数，则直接赋值给结果
                        else result *= value; // 否则执行乘法运算
                        break;
                    case '/':
                        if (result == null || value == 0) return null; // 如果是第一个数或者除数为0，则返回null
                        else result /= value; // 否则执行除法运算
                        break;
                    default:
                        return null; // 如果运算符不合法，则返回null
                }
            } else if ("+-*/".indexOf(token) != -1) { // 如果是运算符，则更新当前运算符
                operator = token.charAt(0);
            } else { // 如果既不是整数也不是变量也不是运算符，则返回null
                return null;
            }
        }
        return result; // 返回最终结果
    }

    // 定义一个方法处理一行输入，如果输入非法，则打印<syntax-error>
    private static void processLine(String line) {
        if (line == null || line.length() == 0) return;
        String[] parts = line.split("=", 2); // 按等号分割输入
        if (parts.length == 1) { // 如果没有等号，则判断是否是out函数
            String part = parts[0].trim();
            if (part.startsWith("out(") && part.endsWith(")")) { // 如果是out函数，则获取参数并打印输出
                String param = part.substring(4, part.length() - 1).trim(); // 获取参数
                if (isVariable(param)) { // 如果参数是变量，则查找其值并打印输出
                    Integer value = variables.get(param); // 获取变量的值，如果未定义，则为null
                    if (value == null) { // 如果变量未定义，则打印<undefined>
                        System.out.println("<undefined>");
                    } else if (value == Integer.MIN_VALUE || value == Integer.MAX_VALUE) { // 如果变量的值是整数的最小值或者最大值，则判断为溢出，并打印<underflow>或者<overflow>
                        System.out.println(value == Integer.MIN_VALUE ? "<underflow>" : "<overflow>");
                    } else { // 否则正常打印变量的值
                        System.out.println(value);
                    }
                } else { // 如果参数不是变量，则打印<syntax-error>
                    System.out.println("<syntax-error>");
                }
            } else { // 如果不是out函数，则打印<syntax-error>
                System.out.println("<syntax-error>");
            }
        } else if (parts.length == 2) { // 如果有等号，则判断是否是let赋值语句
            String left = parts[0].trim(); // 获取等号左边的部分
            String right = parts[1].trim(); // 获取等号右边的部分
            if (left.startsWith("let ") && isVariable(left.substring(4))) { // 如果左边是let关键字加上一个合法的变量名，则计算右边的表达式的值，并赋值给变量
                String var = left.substring(4); // 获取变量名
                Integer value = evaluate(right); // 计算表达式的值，如果非法或者溢出，则为null
                if (value == null) { // 如果表达式的值为null，则移除该变量的映射
                    variables.remove(var);
                } else { // 否则更新该变量的映射
                    variables.put(var, value);
                }
            } else { // 如果左边不是let关键字加上一个合法的变量名，则打印<syntax-error>
                System.out.println("<syntax-error>");
            }
        } else { // 如果有多个等号，则打印<syntax-error>
            System.out.println("<syntax-error>");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建一个扫描器对象，用于读取输入
        int count = 0; // 记录输入的行数，最多支持24行输入
        while (scanner.hasNextLine() && count < 24) { // 循环读取每一行输入，直到没有更多输入或者超过24行
            String line = scanner.nextLine(); // 读取一行输入
            processLine(line); // 处理一行输入
            count++; // 增加输入的行数
        }
        scanner.close(); // 关闭扫描器对象
    }

}