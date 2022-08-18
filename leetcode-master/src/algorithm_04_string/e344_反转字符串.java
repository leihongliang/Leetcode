package algorithm_04_string;

public class e344_反转字符串 {
    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        reverseString(a);
        System.out.println(a);

    }
}
