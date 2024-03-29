package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class m39组合总和 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, 0);
        return res;
    }
    public static void helper (int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum >target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            if (sum >target) break;
            helper(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

//    List<List<Integer>> res = new ArrayList<>();
//    LinkedList<Integer> path = new LinkedList<>();
    static int pathres = 0;
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }
    static void helper (int[] candidates, int target, int startIndex) {
        if (pathres == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (pathres > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            pathres += candidates[i];
            path.offer(i);
            helper(candidates, target, i);
            pathres -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        // 输入：candidates = [2,3,6,7], target = 7
        // 输出：[[2,2,3],[7]]
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result.toString());
    }
}
