package algorithm_04_string;

public class jz20表示数值的字符串 {
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if (str[i] >= '0' && str[i] <= '9' ) {
                numSeen = true;
            }else if(str[i] == '.') {
                //.之前不能出现.或者e
                if(dotSeen || eSeen) return false;
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E') {
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen) return false;
                eSeen = true;
                // 12e,e必须有数
                numSeen = false;
            }else if(str[i] == '-' || str[i] == '+') {
                //+-必须在0位置或者e/E的后面第一个
                if(i != 0 && str[i - 1] != 'E' && str[i - 1] != 'e') return false;
            }else{
                return false;
            }
        }
        return numSeen;

    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(isNumber(s));
    }

}
