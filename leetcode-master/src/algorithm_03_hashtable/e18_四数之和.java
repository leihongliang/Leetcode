package algorithm_03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e18_四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l++;
                    }else if (sum > target) {
                        r--;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l<r && nums[l] == nums[l+1]) l++;
                        l++;
                        while (l<r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, 2, -2};
        int[] nums = { 2, 2, 2, 2, 2};
        List a = fourSum(nums,8);
        System.out.println(a);
    }
}
