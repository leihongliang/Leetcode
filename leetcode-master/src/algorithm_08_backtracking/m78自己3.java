package algorithm_08_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m78自己3 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0);
        return res;
    }
    public static void helper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
//        if (startIndex >= nums.length) {
//            return;
//        }
        for (int i = startIndex; i < nums.length; i++ ) {
            path.add(nums[i]);
            helper(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> reslut =subsets(nums);
        System.out.println(reslut.toString());
    }
}
