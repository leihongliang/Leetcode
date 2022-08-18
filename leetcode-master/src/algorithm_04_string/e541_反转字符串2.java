package algorithm_04_string;

public class e541_反转字符串2 {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int l = 0; l < arr.length; l += 2*k) {
            int r = l + k - 1;
            if (r > arr.length - 1) {
                r = arr.length - 1;
            }
            reverse(arr, l, r);
        }
        return String.valueOf(arr);
    }
    public static void reverse(char[] arr, int l, int r) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }
    }



    public static void main(String[] args) {
        String a = "a";
        String res = reverseStr(a , 4);
        System.out.println(res);

    }
}
