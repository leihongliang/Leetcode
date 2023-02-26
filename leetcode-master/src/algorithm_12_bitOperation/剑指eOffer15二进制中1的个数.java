package algorithm_12_bitOperation;

public class 剑指eOffer15二进制中1的个数 {
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = hammingWeight(11);
        // 00000001011
        System.out.println(res);
    }
}
