package algorithm_03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e18_四数之和 {
    public static List<List<Integer>> fourSum0(int[] nums, int target) {
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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        long sum = 0;
        for (int a = 0; a < nums.length; a++) {
            if( a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < nums.length; b++) {
                if( b > a + 1 && nums[b] == nums[b - 1]) continue;
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    sum = (long)nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) c ++;
                        while (c < d && nums[d] == nums[d - 1]) d --;
                        c ++;
                        d --;
                    }
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, 2, -2};
        int[] nums = { 1000000000,1000000000,1000000000,1000000000};
        List a = fourSum(nums,-294967296);
        System.out.println(a);
    }
}
