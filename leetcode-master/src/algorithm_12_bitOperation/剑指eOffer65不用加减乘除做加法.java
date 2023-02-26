package algorithm_12_bitOperation;

public class 剑指eOffer65不用加减乘除做加法 {
    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int tmp = a & b; // 0001 0000
            int c = tmp << 1;  //进位和 0010 0000
            a ^= b; // 0000 0101
            b = c; // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        // real.a 0001 0100
        // b 0001 0001

        int res = add(20,17);
    }
}
