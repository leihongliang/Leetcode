package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.List;

public class m17电话号码的字母组合 {
    static List<String> res = new ArrayList<>();
    static StringBuilder tmp = new StringBuilder();
    static String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        helper(digits, 0);
        return res;

    }
    public static void helper (String digits, int startIndex) {
        if (tmp.length() == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        char c = digits.charAt(startIndex);//
        int  num = Integer.parseInt(String.valueOf(c));
        String str = numString[num];
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));
            helper(digits, startIndex + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        //输入：digits = "23"
        //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        List<String> reslut =letterCombinations("23");
        System.out.println(reslut.toString());
    }
}
