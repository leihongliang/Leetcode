package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m47全排列2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int[] used = new int[21];
    public static List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return res;
    }
    public static void helper(int[] nums, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            // return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i] + 10 ] == 1) continue;
            path.add(nums[i]);
            used[nums[i] + 10 ] = 1;
            helper(nums, i + 1);
            path.removeLast();
            used[nums[i] + 10 ] = 0;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> reslut =permute(nums);
        System.out.println(reslut.toString());
    }
}
