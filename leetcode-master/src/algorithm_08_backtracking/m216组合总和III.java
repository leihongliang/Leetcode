package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m216组合总和III {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;
    public static List<List<Integer>> combinationSum3(int k, int n) {

        helper(n, k, 1);
        return res;
    }
    public static void helper (int n, int k, int startIndex) {
        if (path.size() == k ) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }
        }
        for (int i = startIndex; i <=  9 - (k - path.size()) + 1 ; i++) {
            path.add(i);
            sum += i;
            helper(n, k, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> reslut =combinationSum3(3, 7);
        System.out.println(reslut.toString());
    }
}
