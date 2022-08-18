package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m131分割回文串 {

    static List<List<String>> res = new ArrayList<>();
    static LinkedList<String> path = new LinkedList<>();
    public static List<List<String>> partition(String s) {
        helper(s, 0);
        return res;
    }
    public static void helper(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList(path));
            return;
        }

        for(int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s, startIndex, i)) {
                break;
            }
            String tmp = s.substring(startIndex, i + 1);
            path.add(tmp);

            helper(s, i + 1);
            path.removeLast();
        }
    }
    public static boolean isPalindrome(String s, int l, int r) {
        for (int i = l, j = r; i <= r; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //输入: candidates =[10,1,2,7,6,1,5], target =8,
        //输出:[[1,1,6],[1,2,5],[1,7],[2,6]]
        String s = "aba";

        List<List<String>> result = partition(s);
        System.out.println(result.toString());
    }
}
