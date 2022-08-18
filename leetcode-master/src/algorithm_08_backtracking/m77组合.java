package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m77组合 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1);
        return res;

    }
    public static void helper (int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
//        for (int i = startIndex; i <= n; i++) {
        for (int i = startIndex; i <= n - (k - path.size() + 1); i++) {
            path.add(i);
            helper(n, k, startIndex + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> reslut =combine(4, 2);
        System.out.println(reslut.toString());
    }
}
