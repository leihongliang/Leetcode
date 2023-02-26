package algorithm_08_backtracking;

import java.util.*;

public class m78组合3 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        helper(nums,  used);
        return res;
    }
    static public void helper(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            helper(nums, used);
            path.pollLast();
            used[i] = 0;
        }
    }



    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> reslut =permuteUnique(nums);
        System.out.println(reslut.toString());
    }
}
