package algorithm_04_string;

public class jz58_左旋转字符串II {
    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder(s.length());
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder(s);
        reverse(res, 0 , n - 1);
        reverse(res, n , s.length() - 1);
        reverse(res, 0, s.length() - 1);
        return  res.toString();
    }
    private static void reverse (StringBuilder sb, int l , int r) {
        while (l < r) {
            char tmp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, tmp);
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        String res = reverseLeftWords2("abcd", 2);
        System.out.println(res);
    }
}

