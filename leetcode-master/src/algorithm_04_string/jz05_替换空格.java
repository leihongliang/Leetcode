package algorithm_04_string;

public class jz05_替换空格 {
    public static String replaceSpace (String s) {
        StringBuffer res = new StringBuffer(s);

        while (res.indexOf(" ") != -1) {
            int i = res.indexOf(" ");
            res.delete(i, i + 1);
            res.insert(i, "%20");
        }
        return res.toString();
    }
    public static String replaceSpace2 (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String res = replaceSpace2("ab c d");
        System.out.println(res);
    }
}
