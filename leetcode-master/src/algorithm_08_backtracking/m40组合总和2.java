package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class m40组合总和2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }
    public static void helper (int[] candidates, int target, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i]> target) break;//剪枝
            // 跳过同一层使用过的元素
            if (i > startIndex && candidates[i] == candidates[i - 1]) break;
            sum += candidates[i];
            path.add(candidates[i]);
            helper(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        //输入: candidates =[10,1,2,7,6,1,5], target =8,
        //输出:[[1,1,6],[1,2,5],[1,7],[2,6]]
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result.toString());
    }
}
