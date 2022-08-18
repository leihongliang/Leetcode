package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m46全排列 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int[] used = new int[21];
    static boolean[] used2 = new boolean[21];
    public static List<List<Integer>> permute(int[] nums) {
        helper2(nums);
        return res;
    }
    public static void helper(int[] nums, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            // return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used2[nums[i] + 10 ]) continue;
            path.add(nums[i]);
            used2[nums[i] + 10 ] = true;
            helper(nums, i + 1);
            path.removeLast();
            used2[nums[i] + 10 ] = false;
        }
    }

    /**
     * helper2
     */
    public static void helper2(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            helper2(nums);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> reslut =permute(nums);
        System.out.println(reslut.toString());
    }
}
