package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m491递增子序列 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0);
        return res;
    }
    public static void helper(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for(int i = start; i < nums.length; i++) {
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    used[nums[i] + 100] == 1) continue;
            path.add(nums[i]);
            used[nums[i] + 100] = 1;
            helper(nums, i + 1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> reslut =findSubsequences(nums);
        System.out.println(reslut.toString());
    }
}
