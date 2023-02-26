package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m216组合总和3 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1);
        return res;
    }
    static void helper(int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.offer(i);
            sum += i;
            helper(k, n, startIndex + 1);
            path.pollLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> reslut =combinationSum3(3, 7);
        System.out.println(reslut.toString());
    }
}
