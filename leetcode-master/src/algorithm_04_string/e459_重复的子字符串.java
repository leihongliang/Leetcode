package algorithm_04_string;

public class e459_重复的子字符串 {
    public static boolean repeatedSubstringPattern1(String s) {
        for(int i = 1; i <= s.length()/2; i++) {
            boolean flag = true;
            if (s.length() % i != 0) continue;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag==true){
                return true;
            }
        }
        return false;
    }
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "abaababaab";
        System.out.println(repeatedSubstringPattern1(a));
    }
}
